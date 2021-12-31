import { getRuleList, saveFlow, remove } from '@/api/tool/crud'

// 权限判断指令
import permission from '@/directive/permission/index.js'

export default {
  name:'crud',
  directives: { permission },
  data() {
    return {     
      formVisible: false,
      formTitle: '添加流程',
      isAdd: true,
      form: {
        flowId: '',
        flowDesc: '',
        bizSysId: '',
        bizType: '',
      },
     
      listQuery: {
        page: 1,
        limit: 20,  
        flowId: undefined,
        flowDesc: undefined,      
      },
      list: null,
      listLoading: true,
      selRow: {}
    }
  },

  created() {
    this.init()
  },
  methods: {
    init() {
      this.fetchData()
    },
    fetchData() {
      this.listLoading = true
      getRuleList(this.listQuery).then(response => {
        this.list = response.data.records
        this.listLoading = false
        this.total = response.data.total
      })
    },
    search() {
      this.listQuery.page = 1
      this.fetchData()
    },
    reset() {
      this.listQuery.flowId = ''
      this.listQuery.flowDesc = ''

      this.fetchData()
    },
    
    handleFilter() {
      this.listQuery.page = 1
      this.getRuleList()
    },
       fetchNext() {
      this.listQuery.page = this.listQuery.page + 1
      this.fetchData()
    },
    fetchPrev() {
      this.listQuery.page = this.listQuery.page - 1
      this.fetchData()
    },
    fetchPage(page) {
      this.listQuery.page = page
      this.fetchData()
    },
    changeSize(limit) {
      this.listQuery.limit = limit
      this.fetchData()
    },
    handleCurrentChange(currentRow, oldCurrentRow) {
      this.selRow = currentRow
    },   

    resetForm() {
      this.form = {
        flowId: '99999999',
        flowDesc: '',
        bizSysId: '',
        bizType: '',
      }
    },
    add() {
      this.resetForm()
      this.formTitle = '添加流程'
      this.formVisible = true
      this.isAdd = true
    },

    saveFlow() {      
      saveFlow(this.form).then(response => {
        this.$message({
          message: '提交成功',
          type: 'success'
        })
        this.fetchData()
        this.formVisible = false
      })
    },

    checkSel() {
      if (this.selRow && this.selRow.flowId) {
        return true
      }
      this.$message({
        message: '请选中操作项',
        type: 'warning'
      })
      return false
    },

    editItem(record){
      this.selRow= Object.assign({},record);
      this.edit()
    },
    edit() {
      if (this.checkSel()) {
        this.isAdd = false
        let form = Object.assign({}, this.selRow);
        this.form = form
        this.formTitle = '修改用户'
        this.formVisible = true
      }
    },
    removeItem(record){
      this.selRow = record
      this.remove()
    },

    removeItem(record){
      this.selRow = record
      this.remove()
    },

    remove() {
      if (this.checkSel()) {
        var id = this.selRow.flowId

        this.$confirm('确定删除该记录?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          remove(id).then(response => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.fetchData()
          }).catch( err=>{
            this.$notify.error({
              title: '错误',
              message:err,
            })
          })
        }).catch(() => {
        })
      }
    }
   

  }
}
