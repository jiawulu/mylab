package cn.easywork

class ProcessController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [processInstanceList: Process.list(params), processInstanceTotal: Process.count()]
    }

    def create = {
        def processInstance = new Process()
        processInstance.properties = params
        return [processInstance: processInstance]
    }

    def save = {
        def processInstance = new Process(params)
        if (processInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'process.label', default: 'Process'), processInstance.id])}"
            redirect(action: "show", id: processInstance.id)
        }
        else {
            render(view: "create", model: [processInstance: processInstance])
        }
    }

    def show = {
        def processInstance = Process.get(params.id)
        if (!processInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'process.label', default: 'Process'), params.id])}"
            redirect(action: "list")
        }
        else {
            [processInstance: processInstance]
        }
    }

    def edit = {
        def processInstance = Process.get(params.id)
        if (!processInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'process.label', default: 'Process'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [processInstance: processInstance]
        }
    }

    def update = {
        def processInstance = Process.get(params.id)
        if (processInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (processInstance.version > version) {
                    
                    processInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'process.label', default: 'Process')] as Object[], "Another user has updated this Process while you were editing")
                    render(view: "edit", model: [processInstance: processInstance])
                    return
                }
            }
            processInstance.properties = params
            if (!processInstance.hasErrors() && processInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'process.label', default: 'Process'), processInstance.id])}"
                redirect(action: "show", id: processInstance.id)
            }
            else {
                render(view: "edit", model: [processInstance: processInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'process.label', default: 'Process'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def processInstance = Process.get(params.id)
        if (processInstance) {
            try {
                processInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'process.label', default: 'Process'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'process.label', default: 'Process'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'process.label', default: 'Process'), params.id])}"
            redirect(action: "list")
        }
    }
}
