<template>
<section>
  <el-row gutter="20" type="flex" justify="center" align="middle">
    <el-col :span="6"
      ><div class="grid-content bg-purple" align="center" >
        <el-link  href="https://www.baidu.com"  type="primary" target="_blank" >百度搜索</el-link>
      </div></el-col
    >
    <el-col :span="6"
      ><div  class="grid-content bg-purple" align="center">
        <el-link href="https://www.google.cn" type="primary" target="_blank">谷歌搜索</el-link>
      </div></el-col
    >
    <el-col :span="6"
      ><div  class="grid-content bg-purple" align="center">
        <el-link href="https://www.github.com" type="primary" target="_blank">Github</el-link>
      </div></el-col
    >
  </el-row>

  <el-row gutter="20" type="flex" justify="center" align="middle">
    <el-col :span="6"
      ><div class="grid-content bg-purple" align="center" >
        <el-link  href="https://www.baidu.com"  type="primary" target="_blank">百度搜索</el-link>
      </div></el-col
    >
    <el-col :span="6"
      ><div  class="grid-content bg-purple" align="center">
        <el-link href="https://www.google.cn" type="primary" target="_blank">谷歌搜索</el-link>
      </div></el-col
    >
    <el-col :span="6"
      ><div  class="grid-content bg-purple" align="center">
        <el-link href="https://www.github.com" type="primary" target="_blank">Github</el-link>
      </div></el-col
    >
  </el-row>
  </section>
</template>

<style>
.el-row {
  margin-bottom: 10px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.el-row {
        height: 100%; 
    }
</style>