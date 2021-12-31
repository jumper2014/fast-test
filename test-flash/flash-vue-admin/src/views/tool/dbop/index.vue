<template>
  <div class="app-container">
    <div class="block">
      <el-row  :gutter="20">
        <el-col :span="4">
          <el-input size="mini" v-model="userInfo.userName" placeholder="请指定UserName"></el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="success" size="mini" icon="el-icon-refresh-right" @click.native="unlockUser">解锁用户</el-button>
           <el-button type="success" size="mini" icon="el-icon-edit" @click.native="lockUser">锁定用户</el-button>
        </el-col>
      </el-row>
 
    </div>
  </div>
</template>

<script src="./dbop.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/common.scss";
</style>
