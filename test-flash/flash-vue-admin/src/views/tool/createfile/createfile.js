import { createFile } from '@/api/tool/createfile'
import permission from '@/directive/permission/index.js'

export default {
  directives: { permission },
  name: 'createfile',
  data() {
    return {
      fileInfo: {
        total: 100,
        },
    }
  },
  methods: {
    createFile() {
      createFile(this.fileInfo).then(response => {
        this.$message({
          message: 'Merchant批量文件生成完成',
          type: 'success'
        })
      }).catch(function (err) {
          console.log(err);
      })
    },

  }

}
