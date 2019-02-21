package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class FloodcontrolResponse extends RBResponse {
    /**
     * data : [{"appid":"3ae815cd128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"0:01:02","funcnamech":"雨量监测","funcurl":"systemmanager/rain/mainForKdb","id":"136359791741054044251","isapp":"1","ismenu":0,"parentid":"136272096970931770620","priority":2},{"appid":"3ae815cd128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"0:01:03","funcnamech":"场降雨累计雨量","funcurl":"systemmanager/rain/city","id":"136645640032534076486","isapp":"1","ismenu":0,"parentid":"136272096970931770620","priority":15},{"appid":"3ae815cd128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"0:01:04","funcnamech":"泵站运行状态监测","funcnameen":"active","funcurl":"systemmanager/pumpbseinfo/main2","id":"136567362010426638241","isapp":"1","ismenu":0,"parentid":"136272096970931770620","priority":10},{"appid":"4500b6b1128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"0:02:01","funcnamech":"降雨量查询","funcurl":"RainController/list","id":"136626924451838383615","isapp":"1","ismenu":0,"parentid":"45045679128711e6aaf8000c29b2d655","priority":1},{"appid":"4500b6b1128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"0:02:02","funcnamech":"降雨强度查询","funcurl":"RaininessTopInfoController/list","id":"136610681844140180465","isapp":"1","ismenu":0,"parentid":"45045679128711e6aaf8000c29b2d655","priority":2},{"appid":"4500b6b1128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"0:02:03","funcnamech":"泵运行状态查询","funcurl":"PumpRunInfoController/list","id":"136567639853784708567","isapp":"1","ismenu":0,"parentid":"45045679128711e6aaf8000c29b2d655","priority":3},{"appid":"3ae815cd128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"1","funcnamech":"汛情实况","icon":"iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTExIDc5LjE1ODMyNSwgMjAxNS8wOS8xMC0wMToxMDoyMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkU0MjAzODA3MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkU0MjAzODA4MTRCRTExRTZBMjMyOUY2OTZBNzUzMjdBIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RTQyMDM4MDUxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RTQyMDM4MDYxNEJFMTFFNkEyMzI5RjY5NkE3NTMyN0EiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4DiV6yAAACw0lEQVR42nSTSWgUURCGvzfT091Oz5LJTIxLMsYFRVARJIKCouBBVDSnoHhxCd5FcY0XEaOBoEcXxEs8JCdBBT0oaPDgVRBRwTXRbI5JZk3P8qz0hCQqVlPUe13bX8tTWkgd7sO/sAa/dnErIfwVl7JVAieC+auEG/oIv5KQ+4m+uRUhxTQpDr7Uunszf1JROCCcF573h0YdeIa9yJkJYMTmD9E9BN+Gi55f2SzDpI+olWfEMEhk5HdshEDKIZAMEo641NuB2YD1Jz/qoVfPwVoAdh1kvgj0BBS+gt+RYLboTNDjYm4SX7dGvCqzCJrVMx68ODoH5HphP/+jfafusrIxNnM3RnSjd+g/prBE1t3StJ64hO0kSVgOhaLF6MA7em+fEG2ZQH4VvkJoNkAk+8M7hKX07GT1Z29X+19590BFhM/P4IBL2PBV6zcrGLli2rsE72ii0+a7j3cQdZqol5GGIxPkUhsYa1mNMwo7OiXrlHNQ8LyemoKx3HP60KZoFE3xhubRtbP/1H6oFy60QsfTWuIxg8m3w1TKDsZA+ZtnsELKUgNSipx3nmqnMdjMyoa1qO81hOxa7I3VrbCHowzxibilqOQEga9Q9AKY13U1VQEed16qdrxbUbdFZpKSPXkTwb9tgvf5T0hV2pB+BS0fRn1+zDNu7VOoLPTs1LScvsJa9hPfBJe3N0jv+5mQb0Qydh2pDtlEc7EnjVEyl3oBAgJkzKiCuH/1jCdXX4a9n/sJC3Z/2eBhe4KWDsmy2KA2nyYWDktDMynP+N5W7T2RbGZqj1yyRo635/RME5PnFWkGycvTWLYorkITGlUsSw9K6emNqArH2xETR3guLZZrTDLEpAzf+58EmixKglq1nX6iP3y+L0NN4ivK5rkuEdthPJBjXqZGnrKLk1lCvmUXDakEhYWjU7lUwZUSa6L8FmAAEiPquBOcPIoAAAAASUVORK5CYII=","id":"136272096970931770620","isapp":"1","ismenu":0,"parentid":"-1","priority":1},{"appid":"4500b6b1128711e6aaf8000c29b2d655","chfuncmid":0,"funccode":"2","funcnamech":"历史数据","icon":"iVBORw0KGgoAAAANSUhEUgAAABsAAAAUCAYAAAB8gkaAAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTExIDc5LjE1ODMyNSwgMjAxNS8wOS8xMC0wMToxMDoyMCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkUzRTI1NDQwMTRCRTExRTY5Q0RBQzBGNjUxOTM2RjE4IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkUzRTI1NDQxMTRCRTExRTY5Q0RBQzBGNjUxOTM2RjE4Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6RTNFMjU0M0UxNEJFMTFFNjlDREFDMEY2NTE5MzZGMTgiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6RTNFMjU0M0YxNEJFMTFFNjlDREFDMEY2NTE5MzZGMTgiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5htC6uAAAFdklEQVR42pxVa0xTZxh+zmlPb/QKLbfSC4UWhHBRxOGoMp3ZDyMhW7YlTuJcJhrQRPdDp/5aYrLEvy4L2c8tbpmC7hJx021yG07GSkGwCE6EcSsgbemNXk7P2VfN3Mx0MN/k63dOz/u9z/t8743q6+uDyWSCVCoFz/M4deokKjZUYt87b6Oj6zq+udqLN3e+hM3Vm7ESZREOLGJ80Alr2WaotRr8JTPO9jO/91w8npa/rhYJ9jKeIkI8h1BksRSFOHh4F5cwdX+swjvYuT9Hb/i28EV7O8Lhfx/i2ecDSwqHJBjg8S6t67018klaXDxeYcr7IOFxhxIJ7h+eEde4OLgU49rABAI6uRUyNJVB03TnQ0fJlUtB5QYW3Z/KJNKKF7a/sU+spJ08CQfFP2JPEZ14LEbOk2exdnUwRihAMBA888MNx3ZDcZmSiVG3eFlaQK5VeyZ8AatrYr5ya2XFV2ZL/pVHjIkjZMXJD5MktRKDUCwClVjtGnl+xx8P/O+13HTtrCoxw6wClNP9NmboO4wM29AnqkZh6RZYCrIcRHsxiZS8gwSi4FgOvEBC0FiyyL8893QwgUCgJtvZFJncvremNDe+PIHKYD+U7dfAeYaRttSF6S5yOKsGEsshTPvq9uaoRSkE6UMCGPw7jf4jG5Nx8Pl877rn3ftDEbaqvKwETNQFOC4hESFpr1CA9TsQltHI2aSHRnYHAcdh3BxqsSmtje9XbtpWo1HhLInV+aeSOHDgANRqdZJNuUKh+MJsttR3dXbZun/pga2kFKkGK9Fi4BvuQ/iGA0IVj1ieGerMdKTnUEjNAzKzPQgstlJL7hmDWFm1hZGl6GmK66EhiCVYFgIS9yQRQUNDgykjI6NZqVQeJawqLJZc2UokgnPnPsPk+ATkxkLottZCUliO+IwT0bEp0KooFCoWtGABVBagKtoNnbYMt2c43JlXyhXgNsqkzC6RRLLExuOux2BNTU35IyMjH8nl8lSdTge/34+CggJUbqxEf28furt/xHJgBdkbXobulVcBmxHsYBtiHh9SivMQTNuNuw7yfDuA5dlchNMyYS0y0FIKmdFYoobjOCvDMF0ELCpobGz0TU5OXiasDOFwON9oNIJ8hF6vR2lZGULBIH66ehXjrmGI9QXQV+2CpqgaD0im9UZfxxi1F4szY8DCKNSGIpRuqYZMpcPUxCxIecpVGmWZUMjsIWB2amBgAC6XC0KhMMvr9dbabLaPUzUaYRIoKUF/ALf6nbj28/e4f/c+auy1eG3fWxBzAbT/Okt2FsXrdKSWElDI1Ij6g/it3wV1hhbrS4pIA6EwOzvbS8C+fgyWZDM3N8cYTSYrIxKdEjHMnmq7HVKxmJQIB5/fh57uTnzd2ooMkw0NBw/BkK0FTXoeRQux4PFjZGgA8243ysrXw1Zgxdz01Ojg0PBxjSa1NydHH3gCzE0UzWYzqUxaNX7v3haFXN5qsVjENTU1D1nG43GMjt3FxdYWqBVylJZXIMZG4fd5SZ/lUVxSjHxbAbweL4aGho9QFP9lMBha1KWn82az6ZkdZJkE9ko0Eim8Nz5+lDhzJFkiSYeKi4qQeagJTqcD8wtuGI1mrC8vh0atITW6jI6OjvMkJEfjbNxDgY+RXrqmEcMRxQkBTZ8cHR1tOXHiRJvdblfV1dVBq9Vh27YdIA5BJBIhQDK4ra3NSQLUJJFIhsgNhB6C8NwTBulVZxdFrZDg3iAr3+FwnD527BgZV+FkQiEUCqG5uTly4cKFw+R9KwHpJSChZ9la6zzjiZEHxOBpUpPX6+vrL5Fk0lRVVX1OavOgTquNkO+J1Yz83+FJxlOsk9RiTnZ2NrO8vBwiYGwyvdcifwowAEVeWKgHiE7EAAAAAElFTkSuQmCC","id":"45045679128711e6aaf8000c29b2d655","isapp":"1","ismenu":0,"parentid":"-1","priority":1}]
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;
    /**
     * appid : 3ae815cd128711e6aaf8000c29b2d655
     * chfuncmid : 0
     * funccode : 0:01:02
     * funcnamech : 雨量监测
     * funcurl : systemmanager/rain/mainForKdb
     * id : 136359791741054044251
     * isapp : 1
     * ismenu : 0
     * parentid : 136272096970931770620
     * priority : 2
     */

    private List<DataEntity> data;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String appid;
        private int chfuncmid;
        private String funccode;
        private String funcnamech;
        private String funcurl;
        private String id;
        private String isapp;
        private int ismenu;
        private String parentid;
        private int priority;

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public void setChfuncmid(int chfuncmid) {
            this.chfuncmid = chfuncmid;
        }

        public void setFunccode(String funccode) {
            this.funccode = funccode;
        }

        public void setFuncnamech(String funcnamech) {
            this.funcnamech = funcnamech;
        }

        public void setFuncurl(String funcurl) {
            this.funcurl = funcurl;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setIsapp(String isapp) {
            this.isapp = isapp;
        }

        public void setIsmenu(int ismenu) {
            this.ismenu = ismenu;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getAppid() {
            return appid;
        }

        public int getChfuncmid() {
            return chfuncmid;
        }

        public String getFunccode() {
            return funccode;
        }

        public String getFuncnamech() {
            return funcnamech;
        }

        public String getFuncurl() {
            return funcurl;
        }

        public String getId() {
            return id;
        }

        public String getIsapp() {
            return isapp;
        }

        public int getIsmenu() {
            return ismenu;
        }

        public String getParentid() {
            return parentid;
        }

        public int getPriority() {
            return priority;
        }
    }
}
