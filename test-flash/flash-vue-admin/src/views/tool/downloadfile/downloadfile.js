import { getApiUrl } from '@/utils/utils'
import permission from '@/directive/permission/index.js'
export default {
  data() {
    return {
      form: {
        fileName: '',
      },
       
    }
  },

  methods: {
    
    //测试下载文件(注意web的上下文)
    handleDownLoad() {
      window.location.href = getApiUrl() +`/files/download?fileName=` + this.form.fileName
    },


  }
}

