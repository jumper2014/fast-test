import { getApiUrl } from '@/utils/utils'
import permission from '@/directive/permission/index.js'
export default {
  data() {
    return {
      form: {
        fileName: '',
      },
       uploadUrl: getApiUrl() + '/files/upload',
       fileList: []
    }
  },

  methods: {
    
    //测试下载文件(注意web的上下文)
    handleDownLoad() {
      // window.location.href = `/files/download?fileName=` + this.form.fileName
    },

      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 5 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
      handleUploadError(error, file) {
    
       this.$notify.error({
                title: 'error',
                message: '上传出错:' +  error,
                type: 'error',
                position: 'bottom-right'
              })
    },
    //测试上传文件(注意web的上下文)
    handleBeforeUpload(file){
        //  this.uploadUrl =`/upload`
    }

  }
}

