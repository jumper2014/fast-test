<template>
  <div style="top: 100px; width: 600px" class="app-container">
    <el-form :model="form" label-width="220px">
      <el-form-item label="请输入服务器上的文件名:" required>
        <el-input
          v-model="form.fileName"
          auto-complete="off"
          class="el-col-width"
          required
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button size="small" type="primary" @click="handleDownLoad"
          >下载文件</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>


<script src="./downloadfile.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
@import "src/styles/common.scss";
</style>

