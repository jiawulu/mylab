package com.taobao.wireless.magic;
/*
 * @author: xiangbin@taobao.com
 * @date  : 2010-6-17  Create file,Base Function
 * @date  : 2010-7-14  duolong@taobao.com, optimize resize funtion 
 *
 * ˵��: 
 *  1. ֻ��resizeImage����true�����ǺϷ�ͼƬ���ű���, ����false���ǷǷ�ͼƬ����Ӧ�ô�������ɾ��
 *  2. imagemaick ��Ҫ ������ 6.6.3��
 *  3. jmagick 5.5.6 �汾����, Ҫ����build, link���µ�imagemagick��
 *  ���¼�¼��
 *  1. ���gif����Ч����ʧ������
 *  
 *  ���ڵ����⣺
 *  1. pngͼƬѹ�����С����
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;

import org.junit.Test;


public class ImgUploadUtilTest
{

    //���������ϴ�������ļ���С
    public static final long MAX_FILE_SIZE = (1024 * 1024 * 5); //5Mbyte
    //���������ϴ���ͼƬ������أ������Ӱ�쵽ϵͳ�ȶ������鲻Ҫ̫��
    public static final int  MAX_IMAGE_PIXEL = (10 * 1000 * 1000);
  
    private boolean resizeImage(String fileName) throws MagickException
    {
        MagickImage image  = null;
        boolean ret = false;

        //����ļ���С�������ļ�̫����ImageMagick�ڴ���䲻��
        if(!checkFileFize(fileName))
        {
            return ret;
        }
        try
        {
        	ImageInfo info = new ImageInfo(fileName);
            image = new MagickImage();
            image.pingImage(info);
            
            String mimeType=image.getImageFormat();
            int width   = (int) image.getDimension().getWidth();
            int height  = (int) image.getDimension().getHeight();
            System.out.println(mimeType);
                   //���ͼƬ��������
            if(width * height > MAX_IMAGE_PIXEL)
            {
                return ret;
            }
            //����ͼƬ
            image.readImage(info);
            //�ȱ�����С
        	if(width > 0 && height > 0 )
            {
        		if(mimeType.equalsIgnoreCase("gif")){
        			MagickImage[] images=image.breakFrames();
        			for(int i=0;i<images.length;i++){  
                       images[i]= images[i].zoomImage(width,height);  
                   }  
        			image =new MagickImage(images);
        		}
        		else{
        			image = image.zoomImage(width, height);
        		}
        		
                image.profileImage("*", null); //clean unuse info
                image.setImageAttribute("comment", null); //clean unuse info
                image.setFileName(fileName + "tmp");
                image.writeImage(info);    
                ret = true;
            }      
		}
    	catch (Exception e){
			e.printStackTrace();
		}
        finally
        {
            if (image != null)
            {
                image.destroyImages();
            }
        }
        return ret;
    }
    //����ļ���С
    public static boolean checkFileFize(String file)
    {
        File f = new File(file);
        if(f.exists() && f.length() < MAX_FILE_SIZE)
        {
            return true;
        }
        return false;
    }
    
    @Test
    public void test() throws MagickException
    {
        String[] fileName = {
//        		"/home/wuzhong/desktop/magic/backup-bad-1.jpg",
//        		"/home/wuzhong/desktop/magic/backup-bad-2.jpg",
//        		"/home/wuzhong/desktop/magic/backup-bad-3.jpg",
        		"/home/wuzhong/desktop/anthony.jpg"
        		};
        boolean[] bRet=new boolean[fileName.length];
        for(int i=0;i<fileName.length;i++){
        	bRet[i]=false;
        	File f1 = new File(fileName[i]);
        	System.out.println("["+i+"]"+"����ѹ���ļ���"+fileName[i]);
        	System.out.println("ѹ��ǰ�Ĵ�С��"+f1.length());
            bRet[i]=resizeImage(fileName[i]);
          	File f2 = new File(fileName[i] + "tmp");
          	System.out.println("ѹ����Ĵ�С��"+f2.length());
            if(bRet[i])
            {
                System.out.println("Save File:" + fileName[i]);
            }
            else
            {
                System.out.println("Delete dirty file:"+ fileName[i]);
            }
        }
    }
    
	@Test
	public void test2() throws MagickException, IOException {
		System.getProperties().setProperty("jmagick.systemclassloader", "no");
		
		//System.out.println(System.getenv().get("LD_LIBRARY_PATH"));
		
		String filePath = "/home/wuzhong/desktop/magic/backup-bad-4.jpg";
		File file = new File(filePath);
		
		long length = file.length();	
		System.out.println(length);
		
		byte[] bs = new byte[(int) length];
		new FileInputStream(file).read(bs);
		
		ImageInfo info = new ImageInfo();
		
		MagickImage image = new MagickImage(info,bs);
		//image.blobToImage(new ImageInfo(),bs);
		
		image.profileImage("*", null); // clean unuse info
		image.setImageAttribute("comment", null); // clean unuse info
		
		image.setFileName("/home/wuzhong/desktop/test");
		
		image.writeImage(new ImageInfo());
		
		
		
	}


}
