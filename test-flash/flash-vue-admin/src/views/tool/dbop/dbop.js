import { setUserStatus } from '@/api/tool/dbop'
import permission from '@/directive/permission/index.js'

export default {
  directives: { permission },
  name: 'dbop',
  data() {
    return {
      userInfo: {
        userName: 'tester1',
        userStatus: undefined
        },
    }
  },
  methods: {
    lockUser() {
      this.userInfo.userStatus = 'L';
      setUserStatus(this.userInfo).then(response => {
         this.$message({
           message: '锁定成功',
           type: 'success'
         })
      }).catch(function (err) {
      console.log(err)
      })
    },
    unlockUser() {
      this.userInfo.userStatus = 'A';
        setUserStatus(this.userInfo).then(response => {
          this.$message({
            message: '解锁成功',
            type: 'success'
          })
        }).catch(function (err) {
        console.log(err);
        })
    }
  }
}
