<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container" />
    <div class="block">
      <p>生成批量文件</p>
      <el-row :gutter="20">
        <el-col :span="4">
          <el-input v-model="file.total" size="mini" placeholder="请指定文件行数" />
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24" :style="{ height: '20px' }" />
      </el-row>
      <el-row>
        <el-col :span="2">
          <el-button type="success" size="mini" icon="el-icon-refresh-right" @click.native="createBatch">生成文件</el-button>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>

import create from '@/api/fasttest/batch'
export default {
  name: 'Batch',
  data() {
    return {
      file: {
        total: ''
      }
    }
  },
  methods: {
    createBatch() {
      create(this.file).then(response => {
        this.$message({
          message: '文件生成成功',
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
