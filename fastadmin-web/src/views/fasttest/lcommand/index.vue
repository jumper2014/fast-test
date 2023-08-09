<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container" />

    <div class="block">
      <p>启动Putty工具</p>
      <el-row>
        <el-col :span="24" :style="{ height: '20px' }" />
      </el-row>
      <el-row>
        <el-col :span="2">
          <el-button type="success" size="mini" icon="el-icon-refresh-right" @click.native="run">运行</el-button>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>

import run from '@/api/fasttest/lcommand'
export default {
  name: 'Lcommand',
  data() {
    return {
      command: {
      }
    }
  },
  methods: {
    run() {
      run(this.command).then(response => {
        this.$message({
          message: '启动完成',
          type: 'success'
        })
      }).catch(function(err) {
        console.log(err)
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
::v-deep .el-input-number .el-input__inner {
  text-align: left;
}
</style>
