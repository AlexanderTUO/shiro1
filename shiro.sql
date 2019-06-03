/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : openlayer

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-05-24 17:30:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for feature
-- ----------------------------
DROP TABLE IF EXISTS `feature`;
CREATE TABLE `feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `radius` double(10,2) DEFAULT NULL,
  `geometry` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feature
-- ----------------------------
INSERT INTO `feature` VALUES ('1', 'LineString', '成南高速', '四川南充', null, '[[105.01350402832031,30.84686279296875],[104.43946838378906,30.664215087890625],[104.66194152832031,30.672454833984375],[104.84321594238281,30.647735595703125],[105.01075744628906,30.634002685546875],[105.18928527832031,30.634002685546875],[105.35682678222656,30.60791015625],[105.53260803222656,30.620269775390625],[105.68092346191406,30.66558837890625],[105.80314636230469,30.706787109375],[105.92124938964844,30.73150634765625],[106.09016418457031,30.772705078125]]');
INSERT INTO `feature` VALUES ('44', 'Point', '反倒是', '水电费', null, '[103.57017517089844,31.13662719726563]');
INSERT INTO `feature` VALUES ('45', 'Point', '水电费', '水电费', null, '[103.34220886230469,30.823516845703125]');
INSERT INTO `feature` VALUES ('46', 'Polygon', '世茂云湖风景区', '成都市', null, '[[[104.28523063659668,30.23317337036133],[104.28093910217285,30.231628417968754],[104.28042411804199,30.227165222167972],[104.27853584289551,30.222358703613285],[104.27750587463379,30.220298767089847],[104.2781925201416,30.216865539550785],[104.27132606506348,30.21171569824219],[104.26480293273926,30.21549224853516],[104.26377296447754,30.218410491943363],[104.27046775817871,30.231628417968754],[104.26806449890137,30.236606597900394],[104.25965309143066,30.23866653442383],[104.25845146179199,30.24347305297852],[104.2536449432373,30.247764587402347],[104.24283027648926,30.249996185302738],[104.23836708068848,30.24742126464844],[104.23699378967285,30.25068283081055],[104.24300193786621,30.25566101074219],[104.24368858337402,30.259094238281254],[104.25004005432129,30.259265899658207],[104.2558765411377,30.26046752929688],[104.25965309143066,30.270080566406254],[104.26377296447754,30.278491973876957],[104.25793647766113,30.282783508300785],[104.24901008605957,30.283813476562504],[104.23596382141113,30.28141021728516],[104.22978401184082,30.274715423583988],[104.22823905944824,30.27986526489258],[104.2339038848877,30.29016494750977],[104.23579216003418,30.296001434326175],[104.23956871032715,30.302696228027347],[104.24471855163574,30.304927825927738],[104.24695014953613,30.307331085205078],[104.25004005432129,30.31848907470703],[104.24969673156738,30.323467254638672],[104.24592018127441,30.326557159423828],[104.24798011779785,30.328102111816406],[104.25810813903809,30.326557159423828],[104.26119804382324,30.3277587890625],[104.26497459411621,30.32878875732422],[104.26823616027832,30.325355529785156],[104.27716255187988,30.315227508544922],[104.28454399108887,30.305442810058594],[104.28814888000488,30.30303955078125],[104.29312705993652,30.302696228027344],[104.29879188537598,30.298404693603516],[104.29930686950684,30.293598175048828],[104.29913520812988,30.28484344482422],[104.2998218536377,30.279006958007812],[104.29638862609863,30.276260375976562],[104.29347038269043,30.273513793945312],[104.29295539855957,30.27059555053711],[104.29261207580566,30.267333984375],[104.29244041442871,30.264759063720703],[104.2946720123291,30.260639190673828],[104.29862022399902,30.256519317626953],[104.29587364196777,30.25531768798828],[104.29312705993652,30.256004333496094],[104.29106712341309,30.252399444580078],[104.29055213928223,30.24913787841797],[104.29278373718262,30.250511169433594],[104.29776191711426,30.250167846679688],[104.30085182189941,30.248966217041016],[104.29879188537598,30.246906280517578],[104.29518699645996,30.246906280517578],[104.2920970916748,30.244674682617188],[104.28900718688965,30.23935317993164],[104.28969383239746,30.23660659790039],[104.29072380065918,30.234031677246094],[104.28952217102051,30.231800079345703],[104.28746223449707,30.231971740722656],[104.28523063659668,30.23317337036133]]]');
INSERT INTO `feature` VALUES ('48', 'Polygon', '龙池国家森林公园', '成都市', null, '[[[103.8046646118164,31.120834350585938],[103.7991714477539,31.15447998046875],[103.76415252685547,31.17645263671875],[103.7545394897461,31.192245483398438],[103.77376556396484,31.219024658203125],[103.78681182861328,31.238250732421875],[103.78681182861328,31.260223388671875],[103.7820053100586,31.2725830078125],[103.7710189819336,31.291122436523438],[103.76483917236328,31.323394775390625],[103.74767303466797,31.339874267578125],[103.7380599975586,31.348114013671875],[103.7442398071289,31.355667114257812],[103.76277923583984,31.3714599609375],[103.75659942626953,31.392059326171875],[103.74629974365234,31.400985717773438],[103.75179290771484,31.4154052734375],[103.73119354248047,31.429824829101562],[103.71883392333984,31.443557739257812],[103.69754791259766,31.466903686523438],[103.68450164794922,31.466903686523438],[103.67076873779297,31.453857421875],[103.64673614501953,31.461410522460938],[103.6391830444336,31.452484130859375],[103.64810943603516,31.444244384765625],[103.67076873779297,31.41265869140625],[103.66252899169922,31.398239135742188],[103.6508560180664,31.363906860351562],[103.65703582763672,31.342620849609375],[103.65360260009766,31.31927490234375],[103.66252899169922,31.313095092773438],[103.67351531982422,31.309661865234375],[103.6728286743164,31.29730224609375],[103.66527557373047,31.284942626953125],[103.6501693725586,31.263656616210938],[103.64879608154297,31.230697631835938],[103.6391830444336,31.207351684570312],[103.61446380615234,31.212844848632812],[103.59455108642578,31.222457885742188],[103.58356475830078,31.221771240234375],[103.56090545654297,31.232070922851562],[103.51764678955078,31.232070922851562],[103.49842071533203,31.232070922851562],[103.48674774169922,31.216964721679688],[103.4970474243164,31.192245483398438],[103.49430084228516,31.161346435546875],[103.4853744506836,31.153106689453125],[103.4853744506836,31.135940551757812],[103.49430084228516,31.122894287109375],[103.48674774169922,31.111907958984375],[103.47919464111328,31.098175048828125],[103.48262786865234,31.08306884765625],[103.48674774169922,31.070709228515625],[103.48331451416016,31.05560302734375],[103.47232818603516,31.04461669921875],[103.47026824951172,31.017837524414062],[103.46820831298828,31.002044677734375],[103.47919464111328,30.999298095703125],[103.53137969970703,31.021270751953125],[103.5354995727539,31.042556762695312],[103.54511260986328,31.050796508789062],[103.55609893798828,31.05560302734375],[103.57463836669922,31.04461669921875],[103.5842514038086,31.035003662109375],[103.60347747802734,31.042556762695312],[103.6233901977539,31.063156127929688],[103.68175506591797,31.089248657226562],[103.70990753173828,31.102981567382812],[103.73600006103516,31.100921630859375],[103.7490463256836,31.114654541015625],[103.74767303466797,31.124267578125],[103.76277923583984,31.120147705078125],[103.7662124633789,31.111221313476562],[103.78131866455078,31.102981567382812],[103.79505157470703,31.109848022460938],[103.8046646118164,31.120834350585938]]]');
INSERT INTO `feature` VALUES ('76', 'Point', '汶川旅游区', '四川阿坝', null, '[103.34220886230469,30.823516845703125]');
INSERT INTO `feature` VALUES ('77', 'Point', '青城山', '成都市', null, '[103.568115234375,30.8990478515625]');
INSERT INTO `feature` VALUES ('78', 'Circle', '汶川旅游区', '四川阿坝', '0.02', '[103.44657897949219,30.76034545898438]');
INSERT INTO `feature` VALUES ('80', 'Circle', '水口镇', '成都市', '0.07', '[103.30856323242189,30.452041625976562]');
INSERT INTO `feature` VALUES ('81', 'Point', 'dddd', 'dddddd', '0.07', '[103.12660217285156,30.611343383789062]');
INSERT INTO `feature` VALUES ('82', 'Point', 'dddd', 'ddddd', '0.07', '[103.24195861816406,30.39093017578125]');
INSERT INTO `feature` VALUES ('83', 'Polygon', 'mmmm', 'mmmmm', null, '[[[103.4088134765625,30.476074218750004],[103.32229614257812,30.47744750976563],[103.33877563476562,30.602416992187504],[103.48434448242188,30.607910156250004],[103.4088134765625,30.476074218750004]]]');
INSERT INTO `feature` VALUES ('84', 'Circle', '毕棚沟', '理县县', '0.14', '[103.06892395019531,31.21490478515625]');
INSERT INTO `feature` VALUES ('85', 'LineString', '国色天香', '成都市', null, '[[103.86474609375,30.572891235351562],[103.82423400878906,30.719833374023438]]');
INSERT INTO `feature` VALUES ('87', 'LineString', 'xll', '喀什喀什2', null, 'SRID=4326;[[76.05710506439209,39.39379692077637],[76.06465816497803,39.38899040222168],[76.07092380523682,39.38426971435547],[76.0783052444458,39.3775749206543],[76.0852575302124,39.370880126953125],[76.09229564666748,39.36135292053223],[76.09761714935303,39.35474395751953],[76.10250949859619,39.34822082519531],[76.10757350921631,39.34109687805176],[76.11323833465576,39.33405876159668],[76.11984729766846,39.32633399963379],[76.12405300140381,39.322214126586914],[76.134352684021,39.328908920288086],[76.14284992218018,39.334659576416016],[76.14842891693115,39.33886528015137],[76.15280628204346,39.344444274902344],[76.15512371063232,39.35096740722656],[76.15478038787842,39.354658126831055],[76.16310596466064,39.354400634765625],[76.16971492767334,39.3544864654541],[76.18190288543701,39.35208320617676],[76.1907434463501,39.35002326965332],[76.20018482208252,39.348134994506836],[76.20773792266846,39.34659004211426],[76.21915340423584,39.34435844421387],[76.23365879058838,39.34161186218262],[76.24481678009033,39.3391227722168],[76.25142574310303,39.33826446533203],[76.25880718231201,39.3391227722168],[76.26739025115967,39.340667724609375],[76.27829074859619,39.34281349182129],[76.28215312957764,39.34281349182129],[76.29013538360596,39.34221267700195],[76.2962293624878,39.34195518493652],[76.30120754241943,39.34161186218262],[76.30884647369385,39.34487342834473],[76.31760120391846,39.346675872802734],[76.32644176483154,39.348134994506836],[76.33605480194092,39.349679946899414],[76.3460111618042,39.35131072998047],[76.35193347930908,39.352169036865234],[76.3566541671753,39.35371398925781],[76.35905742645264,39.3556022644043],[76.35905742645264,39.358177185058594],[76.36558055877686,39.358863830566406],[76.37622356414795,39.360151290893555],[76.38429164886475,39.36100959777832],[76.39115810394287,39.3599796295166],[76.40051364898682,39.35774803161621],[76.41132831573486,39.35551643371582],[76.41785144805908,39.35405731201172],[76.42652034759521,39.35474395751953],[76.4357042312622,39.356117248535156]]');
INSERT INTO `feature` VALUES ('88', 'LineString', '巡逻路', 'xjs', null, 'SRID=4326;[[86.19126856327057,41.77968084812164],[86.19342505931854,41.780871748924255],[86.1955064535141,41.78208410739899],[86.19738399982452,41.782899498939514],[86.19919717311859,41.78328573703766],[86.20093524456024,41.7833286523819],[86.20255529880524,41.78317844867706],[86.20515167713165,41.782631278038025],[86.20712578296661,41.782266497612],[86.20859563350677,41.78201973438263],[86.21023714542389,41.781901717185974],[86.21206104755402,41.781880259513855],[86.21413171291351,41.7817085981369],[86.21589124202728,41.781612038612366],[86.21713578701019,41.78156912326813],[86.21926009654999,41.78154766559601],[86.22105181217194,41.78154766559601],[86.2224143743515,41.78173005580902],[86.22386276721954,41.78208410739899],[86.22512876987457,41.782642006874084],[86.22636258602144,41.78341448307037],[86.22731745243074,41.78457319736481],[86.22818648815156,41.78616106510162],[86.23005330562592,41.790120005607605],[86.23080432415009,41.7917937040329],[86.23151242733002,41.79281294345856],[86.23261749744415,41.794100403785706],[86.23316466808319,41.79455101490021],[86.23432338237762,41.7953234910965],[86.23605072498322,41.79624617099762]]');
INSERT INTO `feature` VALUES ('89', 'LineString', 'bygl', 'xjs', null, 'SRID=4326;[[86.06667995452881,41.82713985443115],[86.1018705368042,41.81100368499756],[86.12058162689209,41.8024206161499],[86.12521648406982,41.80001735687256],[86.12699747085571,41.797635555267334],[86.12858533859253,41.795146465301514],[86.12961530685425,41.7939019203186],[86.13665342330933,41.78879499435425],[86.14085912704468,41.786606311798096],[86.1444640159607,41.78579092025757],[86.15068674087524,41.7849326133728],[86.15806818008423,41.784160137176514],[86.16660833358765,41.78282976150513],[86.16866827011108,41.7820143699646],[86.17145776748657,41.779911518096924],[86.17330312728882,41.77879571914673],[86.17935419082642,41.77828073501587],[86.18686437606812,41.77823781967163],[86.19137048721313,41.77969694137573],[86.19518995285034,41.78205728530884],[86.19763612747192,41.78300142288208],[86.2002968788147,41.783344745635986],[86.20407342910767,41.78282976150513],[86.20887994766235,41.78184270858765],[86.22132539749146,41.781370639801025],[86.22505903244019,41.78244352340698],[86.22741937637329,41.78450345993042],[86.22947931289673,41.78845167160034],[86.23089551925659,41.79179906845093],[86.23252630233765,41.79403066635132],[86.23428583145142,41.79527521133423],[86.23664617538452,41.79669141769409],[86.23806238174438,41.79819345474243],[86.23836278915405,41.79973840713501],[86.23780488967896,41.80171251296997],[86.23587369918823,41.80351495742798],[86.23308420181274,41.806132793426514],[86.23239755630493,41.80776357650757],[86.23274087905884,41.809093952178955],[86.23355627059937,41.81042432785034],[86.23531579971313,41.811325550079346],[86.23720407485962,41.81248426437378],[86.23934984207153,41.814372539520264],[86.24050855636597,41.81518793106079],[86.24252557754517,41.81604623794556],[86.24432802200317,41.81647539138794],[86.24664545059204,41.81814908981323],[86.24840497970581,41.819050312042236],[86.25025033950806,41.81917905807495],[86.25205278396606,41.81887865066528],[86.25424146652222,41.81814908981323],[86.25638723373413,41.81827783584595],[86.258704662323,41.81896448135376],[86.26055002212524,41.81892156600952],[86.26256704330444,41.81840658187866],[86.2662148475647,41.8169903755188],[86.26960515975952,41.81626081466675],[86.27569913864136,41.81664705276489],[86.28041982650757,41.81694746017456],[86.28419637680054,41.81767702102662],[86.28664255142212,41.81862115859986],[86.28926038742065,41.819994449615486],[86.29106283187866,41.82188272476197],[86.29316568374634,41.825230121612556],[86.29685640335083,41.831281185150154],[86.30039691925049,41.83623790740967],[86.30606174468994,41.841301918029785],[86.31086826324463,41.84473514556885],[86.3190221786499,41.8489408493042],[86.33275508880615,41.85563564300537],[86.33867740631104,41.85932636260986],[86.34528636932373,41.86490535736084],[86.35189533233643,41.87117099761963],[86.36605739593506,41.88816547393799],[86.37112140655519,41.89383029937744],[86.37807369232179,41.89958095550537],[86.3857126235962,41.90627574920654]]');
INSERT INTO `feature` VALUES ('90', 'Point', '北京啊啊', '水电费', null, 'SRID=4326;[116.41937255859375,39.89959716796875]');
INSERT INTO `feature` VALUES ('91', 'Point', '哈尔滨', '水电费', null, 'SRID=4326;[126.5570068359375,45.7745361328125]');
INSERT INTO `feature` VALUES ('92', 'Point', '福州市', '水电费', null, 'SRID=4326;[119.30328369140625,26.07330322265625]');
INSERT INTO `feature` VALUES ('93', 'Point', '汕头市', '水电费', null, 'SRID=4326;[116.68647766113281,23.349380493164062]');
INSERT INTO `feature` VALUES ('94', 'Point', '日喀则市', '水电费', null, 'SRID=4326;[88.89312744140625,29.26483154296875]');
INSERT INTO `feature` VALUES ('95', 'Point', '乌鲁木齐', '水电费', null, 'SRID=4326;[87.62969970703125,43.80523681640625]');
INSERT INTO `feature` VALUES ('96', 'Point', '中心是', '水电费', null, 'SRID=4326;[110.643310546875,35.101318359375]');
INSERT INTO `feature` VALUES ('97', 'Point', '汕头市', '啊啊啊啊啊', null, 'SRID=4326;[116.68853759765625,23.33770751953125]');
INSERT INTO `feature` VALUES ('98', 'Point', '三亚市', '啊啊啊啊啊', null, 'SRID=4326;[109.53094482421876,18.24554443359375]');
INSERT INTO `feature` VALUES ('99', 'Point', '瑞丽市', '电放费 ', null, 'SRID=4326;[97.87239074707031,24.012680053710938]');
INSERT INTO `feature` VALUES ('100', 'Point', '景洪市', '电放费 ', null, 'SRID=4326;[100.77372550964355,21.99969291687012]');
INSERT INTO `feature` VALUES ('101', 'Point', '丹东市', '电放费 ', null, 'SRID=4326;[124.36248779296875,39.99298095703125]');
INSERT INTO `feature` VALUES ('102', 'Point', '大连市', '电放费 ', null, 'SRID=4326;[121.62689208984375,38.89984130859375]');
INSERT INTO `feature` VALUES ('103', 'Point', '岢岚县', '电放费 ', null, 'SRID=4326;[111.68495178222656,38.27018737792969]');
INSERT INTO `feature` VALUES ('104', 'Point', '武汉市', '电放费 ', null, 'SRID=4326;[114.3621826171875,30.5914306640625]');
INSERT INTO `feature` VALUES ('105', 'Point', '喀什aaa', '电放费 ', null, 'SRID=4326;[76.014404296875,39.429931640625]');
INSERT INTO `feature` VALUES ('106', 'Point', '乌鲁木齐', '电放费 ', null, 'SRID=4326;[87.659912109375,43.780517578125]');
INSERT INTO `feature` VALUES ('107', 'Point', '阿勒泰', '电放费 ', null, 'SRID=4326;[88.1707763671875,47.8399658203125]');
INSERT INTO `feature` VALUES ('108', 'Point', '普兰县', '电放费 ', null, 'SRID=4326;[81.17660522460938,30.29617309570313]');
INSERT INTO `feature` VALUES ('109', 'Point', '漠河ss', '是否大是大非', null, 'SRID=4326;[122.83538818359376,52.94586181640625]');

-- ----------------------------
-- Table structure for feature_copy
-- ----------------------------
DROP TABLE IF EXISTS `feature_copy`;
CREATE TABLE `feature_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `geometry` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feature_copy
-- ----------------------------
INSERT INTO `feature_copy` VALUES ('40', 'Point', '汶川旅游区', '四川阿坝', '[103.37791442871094,30.883941650390625]');
INSERT INTO `feature_copy` VALUES ('43', 'LineString', '成南高速', '四川南充', '[[104.10163879394531,30.655975341796875],[104.43946838378906,30.664215087890625],[104.66194152832031,30.672454833984375],[104.84321594238281,30.647735595703125],[105.01075744628906,30.634002685546875],[105.18928527832031,30.634002685546875],[105.35682678222656,30.60791015625],[105.53260803222656,30.620269775390625],[105.68092346191406,30.66558837890625],[105.80314636230469,30.706787109375],[105.92124938964844,30.73150634765625],[106.09016418457031,30.772705078125]]');
INSERT INTO `feature_copy` VALUES ('44', 'Point', '反倒是', '水电费', '[103.57017517089844,31.13662719726563]');
INSERT INTO `feature_copy` VALUES ('45', 'Point', '水电费', '水电费', '[103.38340759277344,30.95123291015625]');
INSERT INTO `feature_copy` VALUES ('46', 'Polygon', '世茂云湖风景区', '成都市', '[[[104.28523063659668,30.23317337036133],[104.28093910217285,30.231628417968754],[104.28042411804199,30.227165222167972],[104.27853584289551,30.222358703613285],[104.27750587463379,30.220298767089847],[104.2781925201416,30.216865539550785],[104.27132606506348,30.21171569824219],[104.26480293273926,30.21549224853516],[104.26377296447754,30.218410491943363],[104.27046775817871,30.231628417968754],[104.26806449890137,30.236606597900394],[104.25965309143066,30.23866653442383],[104.25845146179199,30.24347305297852],[104.2536449432373,30.247764587402347],[104.24283027648926,30.249996185302738],[104.23836708068848,30.24742126464844],[104.23699378967285,30.25068283081055],[104.24300193786621,30.25566101074219],[104.24368858337402,30.259094238281254],[104.25004005432129,30.259265899658207],[104.2558765411377,30.26046752929688],[104.25965309143066,30.270080566406254],[104.26377296447754,30.278491973876957],[104.25793647766113,30.282783508300785],[104.24901008605957,30.283813476562504],[104.23596382141113,30.28141021728516],[104.22978401184082,30.274715423583988],[104.22823905944824,30.27986526489258],[104.2339038848877,30.29016494750977],[104.23579216003418,30.296001434326175],[104.23956871032715,30.302696228027347],[104.24471855163574,30.304927825927738],[104.24695014953613,30.307331085205078],[104.25004005432129,30.31848907470703],[104.24969673156738,30.323467254638672],[104.24592018127441,30.326557159423828],[104.24798011779785,30.328102111816406],[104.25810813903809,30.326557159423828],[104.26119804382324,30.3277587890625],[104.26497459411621,30.32878875732422],[104.26823616027832,30.325355529785156],[104.27716255187988,30.315227508544922],[104.28454399108887,30.305442810058594],[104.28814888000488,30.30303955078125],[104.29312705993652,30.302696228027344],[104.29879188537598,30.298404693603516],[104.29930686950684,30.293598175048828],[104.29913520812988,30.28484344482422],[104.2998218536377,30.279006958007812],[104.29638862609863,30.276260375976562],[104.29347038269043,30.273513793945312],[104.29295539855957,30.27059555053711],[104.29261207580566,30.267333984375],[104.29244041442871,30.264759063720703],[104.2946720123291,30.260639190673828],[104.29862022399902,30.256519317626953],[104.29587364196777,30.25531768798828],[104.29312705993652,30.256004333496094],[104.29106712341309,30.252399444580078],[104.29055213928223,30.24913787841797],[104.29278373718262,30.250511169433594],[104.29776191711426,30.250167846679688],[104.30085182189941,30.248966217041016],[104.29879188537598,30.246906280517578],[104.29518699645996,30.246906280517578],[104.2920970916748,30.244674682617188],[104.28900718688965,30.23935317993164],[104.28969383239746,30.23660659790039],[104.29072380065918,30.234031677246094],[104.28952217102051,30.231800079345703],[104.28746223449707,30.231971740722656],[104.28523063659668,30.23317337036133]]]');
INSERT INTO `feature_copy` VALUES ('48', 'Polygon', '龙池国家森林公园', '成都市', '[[[103.8046646118164,31.120834350585938],[103.7991714477539,31.15447998046875],[103.76415252685547,31.17645263671875],[103.7545394897461,31.192245483398438],[103.77376556396484,31.219024658203125],[103.78681182861328,31.238250732421875],[103.78681182861328,31.260223388671875],[103.7820053100586,31.2725830078125],[103.7710189819336,31.291122436523438],[103.76483917236328,31.323394775390625],[103.74767303466797,31.339874267578125],[103.7380599975586,31.348114013671875],[103.7442398071289,31.355667114257812],[103.76277923583984,31.3714599609375],[103.75659942626953,31.392059326171875],[103.74629974365234,31.400985717773438],[103.75179290771484,31.4154052734375],[103.73119354248047,31.429824829101562],[103.71883392333984,31.443557739257812],[103.69754791259766,31.466903686523438],[103.68450164794922,31.466903686523438],[103.67076873779297,31.453857421875],[103.64673614501953,31.461410522460938],[103.6391830444336,31.452484130859375],[103.64810943603516,31.444244384765625],[103.67076873779297,31.41265869140625],[103.66252899169922,31.398239135742188],[103.6508560180664,31.363906860351562],[103.65703582763672,31.342620849609375],[103.65360260009766,31.31927490234375],[103.66252899169922,31.313095092773438],[103.67351531982422,31.309661865234375],[103.6728286743164,31.29730224609375],[103.66527557373047,31.284942626953125],[103.6501693725586,31.263656616210938],[103.64879608154297,31.230697631835938],[103.6391830444336,31.207351684570312],[103.61446380615234,31.212844848632812],[103.59455108642578,31.222457885742188],[103.58356475830078,31.221771240234375],[103.56090545654297,31.232070922851562],[103.51764678955078,31.232070922851562],[103.49842071533203,31.232070922851562],[103.48674774169922,31.216964721679688],[103.4970474243164,31.192245483398438],[103.49430084228516,31.161346435546875],[103.4853744506836,31.153106689453125],[103.4853744506836,31.135940551757812],[103.49430084228516,31.122894287109375],[103.48674774169922,31.111907958984375],[103.47919464111328,31.098175048828125],[103.48262786865234,31.08306884765625],[103.48674774169922,31.070709228515625],[103.48331451416016,31.05560302734375],[103.47232818603516,31.04461669921875],[103.47026824951172,31.017837524414062],[103.46820831298828,31.002044677734375],[103.47919464111328,30.999298095703125],[103.53137969970703,31.021270751953125],[103.5354995727539,31.042556762695312],[103.54511260986328,31.050796508789062],[103.55609893798828,31.05560302734375],[103.57463836669922,31.04461669921875],[103.5842514038086,31.035003662109375],[103.60347747802734,31.042556762695312],[103.6233901977539,31.063156127929688],[103.68175506591797,31.089248657226562],[103.70990753173828,31.102981567382812],[103.73600006103516,31.100921630859375],[103.7490463256836,31.114654541015625],[103.74767303466797,31.124267578125],[103.76277923583984,31.120147705078125],[103.7662124633789,31.111221313476562],[103.78131866455078,31.102981567382812],[103.79505157470703,31.109848022460938],[103.8046646118164,31.120834350585938]]]');
INSERT INTO `feature_copy` VALUES ('53', 'Polygon', '普通用户', 'sdf', '[[[103.81874084472656,30.794677734375],[104.01786804199219,30.919647216796875],[104.12773132324219,30.834503173828125],[104.08241271972656,30.65185546875],[103.61274719238281,30.666961669921875],[103.81874084472656,30.794677734375]]]');
INSERT INTO `feature_copy` VALUES ('57', 'Point', '视频jk', '感知', '[85.572509765625,42.86865234375]');
INSERT INTO `feature_copy` VALUES ('58', 'Point', '雷达tc', '感知', '[85.001220703125,41.3525390625]');
INSERT INTO `feature_copy` VALUES ('59', 'Point', '振动gq', '感知', '[84.342041015625,42.47314453125]');
INSERT INTO `feature_copy` VALUES ('60', 'Point', '红外tc', '感知', '[83.858642578125,40.95703125]');
INSERT INTO `feature_copy` VALUES ('61', 'Point', '界桩', 'bydz', '[87.264404296875,41.044921875]');
INSERT INTO `feature_copy` VALUES ('62', 'Point', 'liaowt', 'bydz', '[82.672119140625,42.25341796875]');
INSERT INTO `feature_copy` VALUES ('63', 'Point', 'tw山口', 'bydz', '[82.584228515625,40.517578125]');
INSERT INTO `feature_copy` VALUES ('64', 'Point', '加油站', 'bydz', '[84.298095703125,39.9462890625]');
INSERT INTO `feature_copy` VALUES ('65', 'LineString', 'xll', 'bydz', '[[81.507568359375,38.38623046875],[83.660888671875,38.49609375],[86.715087890625,39.13330078125],[88.187255859375,39.7705078125]]');
INSERT INTO `feature_copy` VALUES ('66', 'Polygon', '电子wl', '感知', '[[[89.066162109375,40.75927734375],[87.154541015625,42.82470703125],[86.517333984375,44.82421875],[88.450927734375,45.615234375],[89.439697265625,43.6376953125],[89.725341796875,41.98974609375],[89.066162109375,40.75927734375]]]');
INSERT INTO `feature_copy` VALUES ('67', 'Polygon', 'spjk', 'jk范围', '[[[80.277099609375,39.44091796875],[81.859130859375,40.10009765625],[82.342529296875,39.2431640625],[81.419677734375,38.7158203125],[80.496826171875,39.0673828125],[80.277099609375,39.44091796875]]]');
INSERT INTO `feature_copy` VALUES ('68', 'Polygon', 'ldtc', 'jk范围', '[[[87.572021484375,38.2763671875],[90.208740234375,39.90234375],[89.945068359375,38.759765625],[88.516845703125,38.1884765625],[87.572021484375,38.2763671875]]]');
INSERT INTO `feature_copy` VALUES ('69', 'Polygon', '视频监控', '感知设备', '[[[84.96963500976562,42.0721435546875],[84.47525024414062,42.15728759765625],[84.15939331054688,42.29736328125],[84.08523559570312,42.54180908203125],[84.32144165039062,42.89886474609375],[84.43130493164062,43.11859130859375],[84.71145629882812,43.14056396484375],[85.21957397460938,43.00323486328125],[85.67825317382812,42.9510498046875],[85.85403442382812,42.65716552734375],[85.80734252929688,42.31109619140625],[85.46676635742188,42.16278076171875],[85.19760131835938,42.10235595703125],[84.96963500976562,42.0721435546875]]]');
INSERT INTO `feature_copy` VALUES ('70', 'LineString', 'sad', 'asd', '[[103.34083557128906,30.897674560546875],[103.77754211425781,30.970458984375]]');
INSERT INTO `feature_copy` VALUES ('73', 'Point', '3333', '4444', '[104.32205200195312,30.794677734375]');
INSERT INTO `feature_copy` VALUES ('75', 'LineString', '333', '444', '[[104.21493530273438,30.421142578125],[104.55413818359375,30.75897216796875],[104.5733642578125,31.06109619140625],[104.12017822265625,31.076202392578125]]');

-- ----------------------------
-- Table structure for ri_sys_cat
-- ----------------------------
DROP TABLE IF EXISTS `ri_sys_cat`;
CREATE TABLE `ri_sys_cat` (
  `catId` int(11) DEFAULT NULL,
  `id` varchar(11) NOT NULL,
  `catKind` varchar(255) DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `parent` varchar(11) DEFAULT NULL,
  `catCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ri_sys_cat
-- ----------------------------
INSERT INTO `ri_sys_cat` VALUES ('1', '1', '动物', '动物', '动物', '#', '100');
INSERT INTO `ri_sys_cat` VALUES ('2', '2', '植物', '植物', '植物', '#', '200');
INSERT INTO `ri_sys_cat` VALUES ('3', '3', '老虎', '老虎', '老虎', '1', '101');
INSERT INTO `ri_sys_cat` VALUES ('4', '4', '狮子', '狮子', '狮子', '1', '102');
INSERT INTO `ri_sys_cat` VALUES ('5', '5', '白菜', '白菜', '白菜', '2', '201');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `available` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '删除用户信息权限', '/user11', 'user:delete', 'true');
INSERT INTO `sys_permission` VALUES ('2', '配置用户资源权限', '/permission', 'permission:create', 'true');
INSERT INTO `sys_permission` VALUES ('3', '更新用户资源权限', '/permission', 'permission:update', 'true');
INSERT INTO `sys_permission` VALUES ('4', '更新用户信息权限', '/user', 'user:update', 'true');
INSERT INTO `sys_permission` VALUES ('5', '新增用户信息权限', '/user', 'user:add', 'true');
INSERT INTO `sys_permission` VALUES ('6', '查看用户信息权限', '/user', 'user:view', 'true');
INSERT INTO `sys_permission` VALUES ('7', '更新用户信息权限', '/user', 'user:update', 'true');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `available` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', 'true');
INSERT INTO `sys_role` VALUES ('2', 'manager', '管理员', 'true');
INSERT INTO `sys_role` VALUES ('3', 'staff', '员工', 'true');
INSERT INTO `sys_role` VALUES ('4', 'other', '其他', 'true');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `roleId` int(11) DEFAULT NULL,
  `permissionId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('2', '4');
INSERT INTO `sys_role_permission` VALUES ('1', '5');
INSERT INTO `sys_role_permission` VALUES ('1', '6');
INSERT INTO `sys_role_permission` VALUES ('1', '7');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `iphone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updateDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'itdragon', '风潇潇a', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-23 10:02:52', '2019-05-23 10:02:52', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('10', 'itdragon1', '胜多负少', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 08:38:27', '2019-05-24 08:38:27', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('11', 'itdragon1', '胜多负少', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 08:38:27', '2019-05-24 08:38:27', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('2', 'manager', '风潇潇m', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-23 10:09:15', '2019-05-23 10:09:15', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('3', 'user', '风潇潇u12', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', null, '2019-05-24 15:36:54', '2019-05-24 15:36:54', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('4', 'other', '风潇潇o', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 08:38:27', '2019-05-24 08:38:27', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('5', 'itdragon1', '胜多负少ssss', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 13:36:53', '2019-05-24 13:36:53', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('6', 'itdragon1', '胜多负少', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 08:38:27', '2019-05-24 08:38:27', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('7', 'itdragon1', '胜多负少', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 08:38:27', '2019-05-24 08:38:27', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('8', 'itdragon1', '胜多负少', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 08:38:27', '2019-05-24 08:38:27', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('9', 'itdragon1', '胜多负少', 'fbaf6e6d-4c4e-4984-aa9e-794f304831c2', '12349857999', 'itdragon@git.com', '2019-05-24 08:38:27', '2019-05-24 08:38:27', '1', '219b86a44556942f247a89fb267b60ed');
INSERT INTO `sys_user` VALUES ('c01b76873d044b8690a47490062be6fe', 'tyk', '庹炀坤', null, '1820011', null, null, null, '1', null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '3');
INSERT INTO `sys_user_role` VALUES ('4', '3');
INSERT INTO `sys_user_role` VALUES ('c01b76873d044b8690a47490062be6fe', '1');
INSERT INTO `sys_user_role` VALUES ('c01b76873d044b8690a47490062be6fe', '2');

-- ----------------------------
-- Table structure for tree
-- ----------------------------
DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `catId` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(255) DEFAULT NULL,
  `parent` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `geoType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `layerName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`catId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tree
-- ----------------------------
INSERT INTO `tree` VALUES ('1', '10', '#', '矢量', 'Feature', 'group', null);
INSERT INTO `tree` VALUES ('2', '11', '10', '点', 'Point', 'layer', 'pointLayer');
INSERT INTO `tree` VALUES ('3', '12', '10', '线', 'LineString', 'layer', 'lineStringLayer');
INSERT INTO `tree` VALUES ('4', '13', '10', '面', 'Polygon', 'layer', 'polygonLayer');
INSERT INTO `tree` VALUES ('5', '20', '#', '栅格', 'Raster', 'group', null);
INSERT INTO `tree` VALUES ('6', '14', '10', '圆', 'Circle', 'layer', 'circleLayer');
