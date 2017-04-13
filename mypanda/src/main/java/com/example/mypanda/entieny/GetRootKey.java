package com.example.mypanda.entieny;

import java.util.List;

/**
 * Created by 红超 on 2017/3/7.
 */

public class GetRootKey {
    /**
     * authseq :
     * data : {"info":{"hostinfo":{"avatar":"http://i7.pdim.gs/0257040380bd7d294a8017532c07e39b.jpg","bamboos":"1700","name":"德州扑克包子","rid":75217458},"roominfo":{"bulletin":"起床了 现金10000/20000走起 晚上打比赛","cate":"qipai","classification":"棋牌游戏","details":"","display_type":"1","end_time":"1488888953","fans":"1271","id":"820866","name":"包子征战联众220锦标赛","person_num":"1618","pictures":{"img":"http://i9.pdim.gs/90/f5fc1aa9122069494478d5fd32142329/w338/h190.jpg"},"remind_content":"","remind_status":"0","remind_time":"0","room_type":"1","start_time":"1488888957","style_type":"1","type":"1"},"userinfo":{"rid":0},"videoinfo":{"hardware":2,"name":"dota","plflag":"2_3","room_key":"2f34a47209a5499be33e64b739e4a164","scheme":"http","sign":"086e1c84a7137b747ac0108cbd5fd2cb","slaveflag":["4_7","5_9","7_12"],"status":"2","stream_addr":{"HD":"0","OD":"0","SD":"1"},"time":"1792","ts":"&ts=58beab7d&rid=-47450624","watermark":"1"}}}
     * errmsg :
     * errno : 0
     */

    private String authseq;
    private DataBean data;
    private String errmsg;
    private int errno;

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

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
         * info : {"hostinfo":{"avatar":"http://i7.pdim.gs/0257040380bd7d294a8017532c07e39b.jpg","bamboos":"1700","name":"德州扑克包子","rid":75217458},"roominfo":{"bulletin":"起床了 现金10000/20000走起 晚上打比赛","cate":"qipai","classification":"棋牌游戏","details":"","display_type":"1","end_time":"1488888953","fans":"1271","id":"820866","name":"包子征战联众220锦标赛","person_num":"1618","pictures":{"img":"http://i9.pdim.gs/90/f5fc1aa9122069494478d5fd32142329/w338/h190.jpg"},"remind_content":"","remind_status":"0","remind_time":"0","room_type":"1","start_time":"1488888957","style_type":"1","type":"1"},"userinfo":{"rid":0},"videoinfo":{"hardware":2,"name":"dota","plflag":"2_3","room_key":"2f34a47209a5499be33e64b739e4a164","scheme":"http","sign":"086e1c84a7137b747ac0108cbd5fd2cb","slaveflag":["4_7","5_9","7_12"],"status":"2","stream_addr":{"HD":"0","OD":"0","SD":"1"},"time":"1792","ts":"&ts=58beab7d&rid=-47450624","watermark":"1"}}
         */

        private InfoBean info;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * hostinfo : {"avatar":"http://i7.pdim.gs/0257040380bd7d294a8017532c07e39b.jpg","bamboos":"1700","name":"德州扑克包子","rid":75217458}
             * roominfo : {"bulletin":"起床了 现金10000/20000走起 晚上打比赛","cate":"qipai","classification":"棋牌游戏","details":"","display_type":"1","end_time":"1488888953","fans":"1271","id":"820866","name":"包子征战联众220锦标赛","person_num":"1618","pictures":{"img":"http://i9.pdim.gs/90/f5fc1aa9122069494478d5fd32142329/w338/h190.jpg"},"remind_content":"","remind_status":"0","remind_time":"0","room_type":"1","start_time":"1488888957","style_type":"1","type":"1"}
             * userinfo : {"rid":0}
             * videoinfo : {"hardware":2,"name":"dota","plflag":"2_3","room_key":"2f34a47209a5499be33e64b739e4a164","scheme":"http","sign":"086e1c84a7137b747ac0108cbd5fd2cb","slaveflag":["4_7","5_9","7_12"],"status":"2","stream_addr":{"HD":"0","OD":"0","SD":"1"},"time":"1792","ts":"&ts=58beab7d&rid=-47450624","watermark":"1"}
             */

            private HostinfoBean hostinfo;
            private RoominfoBean roominfo;
            private UserinfoBean userinfo;
            private VideoinfoBean videoinfo;

            public HostinfoBean getHostinfo() {
                return hostinfo;
            }

            public void setHostinfo(HostinfoBean hostinfo) {
                this.hostinfo = hostinfo;
            }

            public RoominfoBean getRoominfo() {
                return roominfo;
            }

            public void setRoominfo(RoominfoBean roominfo) {
                this.roominfo = roominfo;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public VideoinfoBean getVideoinfo() {
                return videoinfo;
            }

            public void setVideoinfo(VideoinfoBean videoinfo) {
                this.videoinfo = videoinfo;
            }

            public static class HostinfoBean {
                /**
                 * avatar : http://i7.pdim.gs/0257040380bd7d294a8017532c07e39b.jpg
                 * bamboos : 1700
                 * name : 德州扑克包子
                 * rid : 75217458
                 */

                private String avatar;
                private String bamboos;
                private String name;
                private int rid;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getBamboos() {
                    return bamboos;
                }

                public void setBamboos(String bamboos) {
                    this.bamboos = bamboos;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }
            }

            public static class RoominfoBean {
                /**
                 * bulletin : 起床了 现金10000/20000走起 晚上打比赛
                 * cate : qipai
                 * classification : 棋牌游戏
                 * details :
                 * display_type : 1
                 * end_time : 1488888953
                 * fans : 1271
                 * id : 820866
                 * name : 包子征战联众220锦标赛
                 * person_num : 1618
                 * pictures : {"img":"http://i9.pdim.gs/90/f5fc1aa9122069494478d5fd32142329/w338/h190.jpg"}
                 * remind_content :
                 * remind_status : 0
                 * remind_time : 0
                 * room_type : 1
                 * start_time : 1488888957
                 * style_type : 1
                 * type : 1
                 */

                private String bulletin;
                private String cate;
                private String classification;
                private String details;
                private String display_type;
                private String end_time;
                private String fans;
                private String id;
                private String name;
                private String person_num;
                private PicturesBean pictures;
                private String remind_content;
                private String remind_status;
                private String remind_time;
                private String room_type;
                private String start_time;
                private String style_type;
                private String type;

                public String getBulletin() {
                    return bulletin;
                }

                public void setBulletin(String bulletin) {
                    this.bulletin = bulletin;
                }

                public String getCate() {
                    return cate;
                }

                public void setCate(String cate) {
                    this.cate = cate;
                }

                public String getClassification() {
                    return classification;
                }

                public void setClassification(String classification) {
                    this.classification = classification;
                }

                public String getDetails() {
                    return details;
                }

                public void setDetails(String details) {
                    this.details = details;
                }

                public String getDisplay_type() {
                    return display_type;
                }

                public void setDisplay_type(String display_type) {
                    this.display_type = display_type;
                }

                public String getEnd_time() {
                    return end_time;
                }

                public void setEnd_time(String end_time) {
                    this.end_time = end_time;
                }

                public String getFans() {
                    return fans;
                }

                public void setFans(String fans) {
                    this.fans = fans;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPerson_num() {
                    return person_num;
                }

                public void setPerson_num(String person_num) {
                    this.person_num = person_num;
                }

                public PicturesBean getPictures() {
                    return pictures;
                }

                public void setPictures(PicturesBean pictures) {
                    this.pictures = pictures;
                }

                public String getRemind_content() {
                    return remind_content;
                }

                public void setRemind_content(String remind_content) {
                    this.remind_content = remind_content;
                }

                public String getRemind_status() {
                    return remind_status;
                }

                public void setRemind_status(String remind_status) {
                    this.remind_status = remind_status;
                }

                public String getRemind_time() {
                    return remind_time;
                }

                public void setRemind_time(String remind_time) {
                    this.remind_time = remind_time;
                }

                public String getRoom_type() {
                    return room_type;
                }

                public void setRoom_type(String room_type) {
                    this.room_type = room_type;
                }

                public String getStart_time() {
                    return start_time;
                }

                public void setStart_time(String start_time) {
                    this.start_time = start_time;
                }

                public String getStyle_type() {
                    return style_type;
                }

                public void setStyle_type(String style_type) {
                    this.style_type = style_type;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public static class PicturesBean {
                    /**
                     * img : http://i9.pdim.gs/90/f5fc1aa9122069494478d5fd32142329/w338/h190.jpg
                     */

                    private String img;

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }
            }

            public static class UserinfoBean {
                /**
                 * rid : 0
                 */

                private int rid;

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }
            }

            public static class VideoinfoBean {
                /**
                 * hardware : 2
                 * name : dota
                 * plflag : 2_3
                 * room_key : 2f34a47209a5499be33e64b739e4a164
                 * scheme : http
                 * sign : 086e1c84a7137b747ac0108cbd5fd2cb
                 * slaveflag : ["4_7","5_9","7_12"]
                 * status : 2
                 * stream_addr : {"HD":"0","OD":"0","SD":"1"}
                 * time : 1792
                 * ts : &ts=58beab7d&rid=-47450624
                 * watermark : 1
                 */

                private int hardware;
                private String name;
                private String plflag;
                private String room_key;
                private String scheme;
                private String sign;
                private String status;
                private StreamAddrBean stream_addr;
                private String time;
                private String ts;
                private String watermark;
                private List<String> slaveflag;

                public int getHardware() {
                    return hardware;
                }

                public void setHardware(int hardware) {
                    this.hardware = hardware;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPlflag() {
                    return plflag;
                }

                public void setPlflag(String plflag) {
                    this.plflag = plflag;
                }

                public String getRoom_key() {
                    return room_key;
                }

                public void setRoom_key(String room_key) {
                    this.room_key = room_key;
                }

                public String getScheme() {
                    return scheme;
                }

                public void setScheme(String scheme) {
                    this.scheme = scheme;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public StreamAddrBean getStream_addr() {
                    return stream_addr;
                }

                public void setStream_addr(StreamAddrBean stream_addr) {
                    this.stream_addr = stream_addr;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getTs() {
                    return ts;
                }

                public void setTs(String ts) {
                    this.ts = ts;
                }

                public String getWatermark() {
                    return watermark;
                }

                public void setWatermark(String watermark) {
                    this.watermark = watermark;
                }

                public List<String> getSlaveflag() {
                    return slaveflag;
                }

                public void setSlaveflag(List<String> slaveflag) {
                    this.slaveflag = slaveflag;
                }

                public static class StreamAddrBean {
                    /**
                     * HD : 0
                     * OD : 0
                     * SD : 1
                     */

                    private String HD;
                    private String OD;
                    private String SD;

                    public String getHD() {
                        return HD;
                    }

                    public void setHD(String HD) {
                        this.HD = HD;
                    }

                    public String getOD() {
                        return OD;
                    }

                    public void setOD(String OD) {
                        this.OD = OD;
                    }

                    public String getSD() {
                        return SD;
                    }

                    public void setSD(String SD) {
                        this.SD = SD;
                    }
                }
            }
        }
    }
}
