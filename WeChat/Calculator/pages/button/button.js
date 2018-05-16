// pages/button/button.js
var types = ['default', 'primary', 'warn'];
var pageObject = {
  data: {
    defaultSize: 'default',
    primarySize: 'default',
    warnSize: 'default',
    disabled: false,
    plain: false,
    loading: false
  },
  setDisabled: function (e) {
    this.setData({
      disabled: !this.data.disabled
    });
  },
  setPlain: function (e) {
    this.setData({
      plain: !this.data.plain
    });
  },
  setLoading: function (e) {
    this.setData({
      loading: !this.data.loading
    });
  },
  onGotUserInfo: function (e) {
    console.log(e.detail.errMsg);
    console.log(e.detail.userInfo);
    console.log(e.detail.rawData);
  },
  sentGet: function (e) {
    wx.request({
      url: 'http://localhost:18080/springmvctest', //仅为示例，并非真实的接口地址
      data: {
        code: "oneyuan"
      },
      method: "GET",
      complete: function (res) {
        console.log("complete");
      },
      success: function (res) {
        console.log("success");
      }
    })
  }
}

//根据types给pageObject绑定方法
for (var i = 0; i < types.length; ++i) {
  (function (type) {
    pageObject[type] = function (e) {
      var key = type + 'Size'
      var changedData = {}
      changedData[key] =
        this.data[key] === 'default' ? 'mini' : 'default'
      this.setData(changedData)
    }
  })(types[i]);
}

Page(pageObject);