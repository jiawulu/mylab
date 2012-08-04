package cn.easywork

import org.springframework.beans.propertyeditors.UUIDEditor;

import grails.converters.*
import cn.easywork.vo.ExtFormData;
import cn.easywork.vo.ExtGridData

class CpxxkController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
		//[cpxxkInstanceList: Cpxxk.list(params), cpxxkInstanceTotal: Cpxxk.count()]
		ExtGridData data = new ExtGridData();
		data.total = Cpxxk.count()
		data.items = Cpxxk.list(params)
		render data as JSON
    }

    def create = {
        def cpxxkInstance = new Cpxxk()
        cpxxkInstance.properties = params
        return [cpxxkInstance: cpxxkInstance]
    }

    def save = {
		def file = params.get('pict_file')	
		def name = ''	
		if(file && file.size > 0){
			def webRootDir = servletContext.getRealPath("/upload")
			//def userDir = new File(webRootDir, "/upload")
			//userDir.mkdirs()
			name = UUID.randomUUID().toString();
			file.transferTo(new File( webRootDir, name))
		}
		
        def cpxxkInstance = new Cpxxk(params)
		cpxxkInstance.pict = name
        if (cpxxkInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'cpxxk.label', default: 'Cpxxk'), cpxxkInstance.id])}"
            render "{success:true}"
        }
        else {
             render "{success:false}"
        }
    }

    def show = {
        def cpxxkInstance = Cpxxk.get(params.id)
		ExtFormData formData = new ExtFormData();
        if (!cpxxkInstance) {
			formData.success = false;
        }
        else {
			formData.success = true
			formData.data = cpxxkInstance
        }
		render formData as JSON
    }

    def update = {
        def cpxxkInstance = Cpxxk.get(params.id)
        if (cpxxkInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (cpxxkInstance.version > version) {
                    render "{success:false}"
                    return
                }
            }
			def name = cpxxkInstance.pict
            cpxxkInstance.properties = params
			
			def file = params.get('pict_file')

			if(file && file.size > 0){
				def webRootDir = servletContext.getRealPath("/upload")
				//def userDir = new File(webRootDir, "/upload")
				//userDir.mkdirs()
				name = UUID.randomUUID().toString();
				file.transferTo(new File( webRootDir, name))
			}

			cpxxkInstance.pict = name
			
            if (!cpxxkInstance.hasErrors() && cpxxkInstance.save(flush: true)) {
                 render "{success:true}"
            }
            else {
                 render "{success:false}"
            }
        }
        else {
             render "{success:false}"
        }
    }

    def delete = {
		def ids = params.id
		def idArr = ids.split(',')
		idArr.each { id ->	
			def cpxxkInstance = Cpxxk.get(id)
			if (cpxxkInstance) {
				cpxxkInstance.delete(flush: true)
			}
		}
		render "{success:true}"
    }
}
