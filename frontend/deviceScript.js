var axios = require('axios');
var data = '';
var url = 'http://34.172.72.72:8082/api/devices/get/all/';

var config = {
  method: 'get',
  url: url,
  headers: { },
  data : data
};

axios(config)
.then(function (response) {
  var devices = response.data;
  console.log(devices);
})
.catch(function (error) {
  console.log(error);
});