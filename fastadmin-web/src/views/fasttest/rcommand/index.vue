<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container" />

    <div class="block">
      <p>运行远程命令</p>
      <el-row :gutter="20">
        <el-col :span="4">
          <el-input v-model="command.cmd" size="mini" placeholder="请指定远程命令" />
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24" :style="{ height: '20px' }" />
      </el-row>
      <el-row>
        <el-col :span="2">
          <el-button type="success" size="mini" icon="el-icon-refresh-right" @click.native="run">运行</el-button>
        </el-col>
      </el-row>
      <el-row>
        <p>运行结果</p>
        <textarea id="content" v-model="result" name="content" rows="20" cols="80" />
      </el-row>
    </div>
  </div>
</template>
<script>

import run from '@/api/fasttest/rcommand'
export default {
  name: 'Rcommand',
  data() {
    return {
      command: {
        cmd: ''
      },
      result: ''
    }
  },
  methods: {
    run() {
      run(this.command).then(response => {
        this.result = response
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
