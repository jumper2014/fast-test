<template>
  <div class="app-container">
    <div class="block">
      <el-row>
        <el-col :span="6"
          ><div class="grid-content bg-purple">
            <el-input
              size="mini"
              v-model="fileInfo.total"
              placeholder="请指定记录条数"
            ></el-input></div
        ></el-col>
        <el-col :span="6"
          ><div class="grid-content bg-purple-light">
            <el-button
              type="success"
              size="mini"
              icon="el-icon-edit"
              @click.native="createFile"
              >创建导入文件</el-button
            >
          </div></el-col
        >
      </el-row>

     

    </div>
  </div>
</template>

<script src="./createfile.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
@import "src/styles/common.scss";
</style>
