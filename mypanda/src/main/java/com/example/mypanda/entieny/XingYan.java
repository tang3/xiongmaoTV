package com.example.mypanda.entieny;

import java.util.List;

/**
 * Created by 红超 on 2017/3/7.
 */

public class XingYan {
    /**
     * data : {"cname":"熊猫星颜","ename":"xingyan","icon":"https://image.xingyan.panda.tv/c9d21eed1c6b0557e24fe2c89a2ec751.png","items":[{"avatar":"http://i5.pdim.gs/84eaa728c2e56c84a1488c71322a6333.jpg","city":"成都市","display_type":"2","level":"10","levelicon":"anchor10","name":"即兴说唱歌手","nickName":"说唱艺人爆音","personnum":"14933","photo":"https://image.xingyan.panda.tv/8ba95642a23b2483faa78fbf25f4cb94.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"四川省","rid":"62660576","s_photo":"https://image.xingyan.panda.tv/8ba95642a23b2483faa78fbf25f4cb94.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"1","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/a23cfb658818c9c3be966f37ff763b95.flv","style_type":"301","xid":"1125066"},{"avatar":"http://i6.pdim.gs/e2eb09a99bc2e0c79e09da78aae4e0ee.jpg","city":"","display_type":"2","level":"10","levelicon":"anchor10","name":"熊猫夜话电台","nickName":"美女直播电台","personnum":"11807","photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"","rid":"58265988","s_photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"1","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/54740b8e15807161d0b9090403db9aac.flv","style_type":"301","xid":"1124025"},{"avatar":"http://i6.pdim.gs/44fffb096cd528be9c8379280c391367.jpg","city":"呼伦贝尔市","display_type":"2","level":"8","levelicon":"anchor8","name":"苦涩猫咪","nickName":"苦涩猫咪","personnum":"4051","photo":"https://image.xingyan.panda.tv/e5228549c697080d919c66467f8b27b7.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"内蒙古自治区","rid":"64499768","s_photo":"https://image.xingyan.panda.tv/e5228549c697080d919c66467f8b27b7.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"2","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/0d6b8a52e022abbb200e4fa6b9f424d0.flv","style_type":"301","xid":"1695897"},{"avatar":"http://i6.pdim.gs/00d6f4eae14c0c63e2e006cb0942ad0b.jpg","city":"上海市","display_type":"2","level":"6","levelicon":"anchor6","name":"???","nickName":"桃子少女Zzz","personnum":"8976","photo":"https://image.xingyan.panda.tv/b61e5a8f9120e436fed49052b6c79301.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"上海市","rid":"64327966","s_photo":"https://image.xingyan.panda.tv/b61e5a8f9120e436fed49052b6c79301.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"1","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/0c84cd9c5325da3cde72d3b6515b93f1.flv","style_type":"301","xid":"1691671"}],"place":"2","total":150}
     * errmsg :
     * errno : 0
     */

    private DataBean data;
    private String errmsg;
    private int errno;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public static class DataBean {
        /**
         * cname : 熊猫星颜
         * ename : xingyan
         * icon : https://image.xingyan.panda.tv/c9d21eed1c6b0557e24fe2c89a2ec751.png
         * items : [{"avatar":"http://i5.pdim.gs/84eaa728c2e56c84a1488c71322a6333.jpg","city":"成都市","display_type":"2","level":"10","levelicon":"anchor10","name":"即兴说唱歌手","nickName":"说唱艺人爆音","personnum":"14933","photo":"https://image.xingyan.panda.tv/8ba95642a23b2483faa78fbf25f4cb94.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"四川省","rid":"62660576","s_photo":"https://image.xingyan.panda.tv/8ba95642a23b2483faa78fbf25f4cb94.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"1","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/a23cfb658818c9c3be966f37ff763b95.flv","style_type":"301","xid":"1125066"},{"avatar":"http://i6.pdim.gs/e2eb09a99bc2e0c79e09da78aae4e0ee.jpg","city":"","display_type":"2","level":"10","levelicon":"anchor10","name":"熊猫夜话电台","nickName":"美女直播电台","personnum":"11807","photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"","rid":"58265988","s_photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"1","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/54740b8e15807161d0b9090403db9aac.flv","style_type":"301","xid":"1124025"},{"avatar":"http://i6.pdim.gs/44fffb096cd528be9c8379280c391367.jpg","city":"呼伦贝尔市","display_type":"2","level":"8","levelicon":"anchor8","name":"苦涩猫咪","nickName":"苦涩猫咪","personnum":"4051","photo":"https://image.xingyan.panda.tv/e5228549c697080d919c66467f8b27b7.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"内蒙古自治区","rid":"64499768","s_photo":"https://image.xingyan.panda.tv/e5228549c697080d919c66467f8b27b7.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"2","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/0d6b8a52e022abbb200e4fa6b9f424d0.flv","style_type":"301","xid":"1695897"},{"avatar":"http://i6.pdim.gs/00d6f4eae14c0c63e2e006cb0942ad0b.jpg","city":"上海市","display_type":"2","level":"6","levelicon":"anchor6","name":"???","nickName":"桃子少女Zzz","personnum":"8976","photo":"https://image.xingyan.panda.tv/b61e5a8f9120e436fed49052b6c79301.jpeg?x-oss-process=image/quality,q_70","playstatus":"1","province":"上海市","rid":"64327966","s_photo":"https://image.xingyan.panda.tv/b61e5a8f9120e436fed49052b6c79301.jpeg?x-oss-process=image/resize,w_480/quality,q_70","sc":"1","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/0c84cd9c5325da3cde72d3b6515b93f1.flv","style_type":"301","xid":"1691671"}]
         * place : 2
         * total : 150
         */

        private String cname;
        private String ename;
        private String icon;
        private String place;
        private int total;
        private List<ItemsBean> items;

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * avatar : http://i5.pdim.gs/84eaa728c2e56c84a1488c71322a6333.jpg
             * city : 成都市
             * display_type : 2
             * level : 10
             * levelicon : anchor10
             * name : 即兴说唱歌手
             * nickName : 说唱艺人爆音
             * personnum : 14933
             * photo : https://image.xingyan.panda.tv/8ba95642a23b2483faa78fbf25f4cb94.jpeg?x-oss-process=image/quality,q_70
             * playstatus : 1
             * province : 四川省
             * rid : 62660576
             * s_photo : https://image.xingyan.panda.tv/8ba95642a23b2483faa78fbf25f4cb94.jpeg?x-oss-process=image/resize,w_480/quality,q_70
             * sc : 1
             * streamurl : http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/a23cfb658818c9c3be966f37ff763b95.flv
             * style_type : 301
             * xid : 1125066
             */

            private String avatar;
            private String city;
            private String display_type;
            private String level;
            private String levelicon;
            private String name;
            private String nickName;
            private String personnum;
            private String photo;
            private String playstatus;
            private String province;
            private String rid;
            private String s_photo;
            private String sc;
            private String streamurl;
            private String style_type;
            private String xid;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getLevelicon() {
                return levelicon;
            }

            public void setLevelicon(String levelicon) {
                this.levelicon = levelicon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPersonnum() {
                return personnum;
            }

            public void setPersonnum(String personnum) {
                this.personnum = personnum;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getPlaystatus() {
                return playstatus;
            }

            public void setPlaystatus(String playstatus) {
                this.playstatus = playstatus;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getRid() {
                return rid;
            }

            public void setRid(String rid) {
                this.rid = rid;
            }

            public String getS_photo() {
                return s_photo;
            }

            public void setS_photo(String s_photo) {
                this.s_photo = s_photo;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getStreamurl() {
                return streamurl;
            }

            public void setStreamurl(String streamurl) {
                this.streamurl = streamurl;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            public String getXid() {
                return xid;
            }

            public void setXid(String xid) {
                this.xid = xid;
            }
        }
    }
}
