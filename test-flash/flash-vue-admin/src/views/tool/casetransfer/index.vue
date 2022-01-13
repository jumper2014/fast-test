<template>
  <div style="top: 100px; width: 600px">
    <p >请上传百度脑图文件*.km转换成Excel格式的测试用例</p>
    <el-form :model="form" label-width="120px" align="left">
      <el-form-item>
        <el-upload
          class="upload-demo"
          :action="uploadUrl"
          :before-upload="handleBeforeUpload"
          :on-error="handleUploadError"
          :before-remove="beforeRemove"
          multiple
          accept=".km"
          :limit="5"
          :on-exceed="handleExceed"
          :on-success="handleSuccess"
          :file-list="fileList"
        >
          <el-button size="small" type="primary">选择本地文件</el-button>
          <!-- <div slot="tip" class="el-upload__tip">大小不超过5Mb</div> -->
        </el-upload>
      </el-form-item>
    </el-form>
  <div>
  <p >{{fileOnServer}}</p>
  <el-button type="success" size="mini" icon="el-icon-refresh-right"  v-on:click="handleDownLoad">下载转换后的文件</el-button>
  </div>
  </div>
</template>


<script src="./casetransfer.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
@import "src/styles/common.scss";
</style>

