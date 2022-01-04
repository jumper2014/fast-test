<template>
  <div class="app-container">
    <div class="block">
       <el-row>
        指定文件行数
       </el-row>
      <el-row>
        <el-col :span="6"
          ><div class="grid-content bg-purple">
            <el-input
              size="mini"
              v-model="fileInfo.total"
              placeholder="指定文件行数"
            ></el-input></div
        ></el-col>
        <el-col :span="6"
          ><div class="grid-content bg-purple-light">
            <el-button
              type="success"
              size="mini"
              icon="el-icon-edit"
              @click.native="createFile"
              >创建文件</el-button
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
