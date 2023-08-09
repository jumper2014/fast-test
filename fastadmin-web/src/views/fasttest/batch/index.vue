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
      <el-row>
        <p>转换后的文件名:</p>
      </el-row>
      <el-row>
        <p>{{ fileOnServer }}</p>
      </el-row>
      <el-row>
        <el-button
          type="success"
          size="mini"
          icon="el-icon-download"
          @click="handleDownLoad"
        >下载批量文件</el-button>
      </el-row>
    </div>
  </div>
</template>
<script>

import { mapGetters } from 'vuex'
import create from '@/api/fasttest/batch'
export default {
  name: 'Batch',
  data() {
    return {
      file: {
        total: ''
      },
      fileOnServer: ''
    }
  },
  computed: {
    ...mapGetters([
      'baseApi',
      'fileUploadApi'
    ])
  },
  methods: {
    createBatch() {
      create(this.file).then(response => {
        this.$message({
          message: '文件生成成功',
          type: 'success'
        })
        this.fileOnServer = response
      }).catch(function(err) {
        console.log(err)
      })
    },
    handleDownLoad() {
      window.location.href = this.baseApi + '/api/batch/download?fileName=' + this.fileOnServer
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
::v-deep .el-input-number .el-input__inner {
  text-align: left;
}
</style>
