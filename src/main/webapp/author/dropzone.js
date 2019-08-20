Dropzone.options.newsimg = {
    url: "/youya_news/fileUpAndDown/upload", // 文件提交地址
    method: "post",  // 也可用put
    paramName: "dropzFile", // 默认为file
    maxFiles: 1,// 一次性上传的文件数量上限
    maxFilesize: 10, // 文件大小，单位：MB
    clickable:true,
    acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
    addRemoveLinks: true,
    dictRemoveFile:"Remove",
    parallelUploads: 1,// 一次上传的文件数量
    // previewsContainer:"#preview", // 上传图片的预览窗口
    // previewTemplate: $('#preview').html(),
    dictDefaultMessage: 'update',
    dictMaxFilesExceeded: "most one!",
    dictResponseError: 'false',
    dictInvalidFileType: "only *.jpg,*.gif,*.png,*.jpeg",
    dictFallbackMessage: "not support",
    dictFileTooBig: "too big!",
    dictRemoveLinks: "Remove",
    dictCancelUpload: "Cancel",
    init: function () {

        this.on("addedfile", function (file) {
            // 上传文件时触发的事件
        });
        this.on("success", function (file, data) {
            // 上传成功触发的事件
            console.log(data);
            console.log(file);
            $("#oldimg").remove();
            $("#nowimg").val(data.serverPath+"/"+data.filename)
        });
        this.on("error", function (file, data) {
            // 上传失败触发的事件
            console.error(data);
            console.log(file);
        });
        this.on("removedfile", function (file) {
            // 删除文件时触发的方法
        });
    }
}