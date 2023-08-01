<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container" />

    <div class="block">
      <p>解锁用户表中的用户</p>
      <el-row :gutter="20">
        <el-col :span="4">
          <el-input v-model="user.name" size="mini" placeholder="请指定UserName" />
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24" :style="{ height: '20px' }" />
      </el-row>
      <el-row>
        <el-col :span="2">
          <el-button type="success" size="mini" icon="el-icon-refresh-right" @click.native="unlockUser">解锁用户</el-button>
        </el-col>
        <el-button type="success" size="mini" icon="el-icon-edit" @click.native="lockUser">锁定用户</el-button>
        <el-col :span="2" />
      </el-row>
    </div>
  </div>
</template>
<script>

import edit from '@/api/fasttest/dbop'
export default {
  name: 'Dbop',
  data() {
    return {
      user: {
        name: ''
      }
    }
  },
  methods: {
    lockUser() {
      this.user.enabled = false
      edit(this.user).then(response => {
        this.$message({
          message: '锁定成功',
          type: 'success'
        })
      }).catch(function(err) {
        console.log(err)
      })
    },
    unlockUser() {
      this.user.enabled = true
      edit(this.user).then(response => {
        this.$message({
          message: '解锁成功',
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
