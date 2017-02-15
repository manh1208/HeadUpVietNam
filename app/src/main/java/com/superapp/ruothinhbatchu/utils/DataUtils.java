package com.superapp.ruothinhbatchu.utils;



import com.superapp.ruothinhbatchu.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ManhNV on 2/24/2016.
 */
public class DataUtils {
    private static DataUtils INSTANCE =null;
    private int times;
    private boolean key;
    private HashMap<Integer,Boolean> list;
    private DataUtils(){
        times = 0;
        list = new HashMap<Integer,Boolean>();
        list.put(R.drawable.animal,true);
        list.put(R.drawable.food,true);

    }
    public static synchronized DataUtils getINSTANCE(){
        if (INSTANCE==null){
            INSTANCE = new DataUtils();

        }
        return INSTANCE;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public List<Integer> getListMenu(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.animal);
        list.add(R.drawable.cadao);
        list.add(R.drawable.cartoon);
        list.add(R.drawable.cinema);
        list.add(R.drawable.famous);
        list.add(R.drawable.food);
        list.add(R.drawable.singer);
        list.add(R.drawable.sport);
        list.add(R.drawable.truyencotich);
        list.add(R.drawable.mobileapp);
        list.add(R.drawable.howtoplay);
        list.add(R.drawable.likeus);
        list.add(R.drawable.rating);
        list.add(R.drawable.hotgame);
        list.add(R.drawable.aboutus);
        return list;
    }

    public HashMap<Integer,Boolean> getListLock(){
        return list;
    }

    public void setUnlock(int Id){
        list.put(Id,false);
    }

    public HashMap<Integer,String> getListAnimal(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.cv1,"Sư tử");
        list.put(R.drawable.cv2,"Gấu");
        list.put(R.drawable.cv3,"Mèo");
        list.put(R.drawable.cv4,"Sói");
        list.put(R.drawable.cv5,"Heo");
        list.put(R.drawable.cv6,"Bò");
        list.put(R.drawable.cv7,"Gấu bắc cực");
        list.put(R.drawable.cv8,"Hươu cao cổ");
        list.put(R.drawable.cv9,"Trâu");
        list.put(R.drawable.cv10,"Chó");
        list.put(R.drawable.cv11,"Hổ");
        list.put(R.drawable.cv12,"Báo đốm");
        list.put(R.drawable.cv13,"Cá sấu");
        list.put(R.drawable.cv14,"Voi");
        list.put(R.drawable.cv15,"Hà mã");
        list.put(R.drawable.cv16,"Lạc đà");
        list.put(R.drawable.cv17,"Sóc");
        list.put(R.drawable.cv18,"Vịt");
        list.put(R.drawable.cv19,"Gà");
        list.put(R.drawable.cv20,"Ngựa");
        list.put(R.drawable.cv21,"Đại bàng");
        list.put(R.drawable.cv22,"Chim");
        list.put(R.drawable.cv23,"Ếch");
        list.put(R.drawable.cv24,"Rắn");
        list.put(R.drawable.cv25,"Cá mập");
        list.put(R.drawable.cv26,"Khỉ");
        list.put(R.drawable.cv27,"Dê");
        list.put(R.drawable.cv28,"Cừu");
        list.put(R.drawable.cv29,"Thỏ");
        list.put(R.drawable.cv30,"Cá voi");
        return list;
    }

    public HashMap<Integer,String> getListSport(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.tt1,"Bóng chày");
        list.put(R.drawable.tt2,"Lướt sóng");
        list.put(R.drawable.tt3,"Trượt tuyết");
        list.put(R.drawable.tt4,"Điền kinh");
        list.put(R.drawable.tt5,"Nhảy cao");
        list.put(R.drawable.tt6,"Aikido");
        list.put(R.drawable.tt7,"Karate");
        list.put(R.drawable.tt8,"Kendo");
        list.put(R.drawable.tt9,"Bơi");
        list.put(R.drawable.tt10,"Tenis");
        list.put(R.drawable.tt11,"Cầu lông");
        list.put(R.drawable.tt12,"Cầu mây");
        list.put(R.drawable.tt13,"Bóng đá");
        list.put(R.drawable.tt14,"Bóng rổ");
        list.put(R.drawable.tt15,"Bóng chuyền");
        list.put(R.drawable.tt16,"Bóng ném");
        list.put(R.drawable.tt17,"Bóng chuyền bãi biển");
        list.put(R.drawable.tt18,"Trượt băng nghệ thuật");
        list.put(R.drawable.tt19,"Đua xe đạp");
        list.put(R.drawable.tt20,"Thể dục dụng cụ");
        list.put(R.drawable.tt21,"Mây thái");
        list.put(R.drawable.tt22,"Boxing");
        list.put(R.drawable.tt23,"Wushu");
        list.put(R.drawable.tt24,"Vovinam");
        list.put(R.drawable.tt25,"Bơi nghệ thuật");
        list.put(R.drawable.tt26,"Sumo");
        list.put(R.drawable.tt27,"Trượt ván");
        list.put(R.drawable.tt28,"Leo núi");
        list.put(R.drawable.tt29,"Aerobic");
        list.put(R.drawable.tt30,"Cricket");
        return list;
    }

    public HashMap<Integer,String> getListMobileApp(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.ah1,"Like");
        list.put(R.drawable.ah2,"Zalo");
        list.put(R.drawable.ah3,"ZingMP3");
        list.put(R.drawable.ah4,"Candy crush");
        list.put(R.drawable.ah5,"Sodoku");
        list.put(R.drawable.ah6,"Dump way to die");
        list.put(R.drawable.ah7,"Temple Run");
        list.put(R.drawable.ah8,"Uber");
        list.put(R.drawable.ah9,"Bắt chữ");
        list.put(R.drawable.ah10,"Youtube");
        list.put(R.drawable.ah11,"Snow");
        list.put(R.drawable.ah12,"Cut of frog");
        list.put(R.drawable.ah13,"King Cup");
        list.put(R.drawable.ah14,"Final Fantasy");
        list.put(R.drawable.ah15,"Đập chuột");
        list.put(R.drawable.ah16,"Dropbox");
        list.put(R.drawable.ah17,"Pacman");
        list.put(R.drawable.ah18,"Pinterest");
        list.put(R.drawable.ah19,"Plans and zombie");
        list.put(R.drawable.ah20,"Truyện ma");
        list.put(R.drawable.ah21,"Instagram");
        list.put(R.drawable.ah22,"Talking tom");
        list.put(R.drawable.ah23,"Pokemon Go");
        list.put(R.drawable.ah24,"Karaoke");
        list.put(R.drawable.ah25,"Hay đấy");
        list.put(R.drawable.ah26,"Frult Ninja");
        list.put(R.drawable.ah27,"Dating");
        list.put(R.drawable.ah28,"Angry birds");
        list.put(R.drawable.ah29,"Angry birds");
        list.put(R.drawable.ah30,"Flappy bird");
        return list;
    }

    public HashMap<Integer,String> getListCadao(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.cd1,"Ăn cháo đá bát");
        list.put(R.drawable.cd2,"Còn nước còn tát");
        list.put(R.drawable.cd3,"Ngựa quen đường cũ");
        list.put(R.drawable.cd4,"Vợ nào chồng nấy");
        list.put(R.drawable.cd5,"Kiến tha lâu đầy tổ");
        list.put(R.drawable.cd6,"Cái khó ló cái khôn");
        list.put(R.drawable.cd7,"Có mới nới cũ");
        list.put(R.drawable.cd8,"Đất lành chim đậu");
        list.put(R.drawable.cd9,"Trao trứng cho ác");
        list.put(R.drawable.cd10,"Giận quá mất khôn");
        list.put(R.drawable.cd11,"Ăn không ngồi rồi");
        list.put(R.drawable.cd12,"Gừng càng già càng cay");
        list.put(R.drawable.cd13,"Ếch ngồi đáy giếng");
        list.put(R.drawable.cd14,"Học một biết mười");
        list.put(R.drawable.cd15,"Khỉ ho cò gáy");
        list.put(R.drawable.cd16,"Mật ngọt chết ruồi");
        list.put(R.drawable.cd17,"Mèo mã gà đồng");
        list.put(R.drawable.cd18,"Ngọt như mía lùi");
        list.put(R.drawable.cd19,"Có chí thì nên");
        list.put(R.drawable.cd20,"Ông nói gà bà nói vịt");
        list.put(R.drawable.cd21,"Rừng vàng biển bạc");
        list.put(R.drawable.cd22,"Tiên học lễ hậu học văn");
        list.put(R.drawable.cd23,"Thả hổ về rừng");
        list.put(R.drawable.cd24,"Ăn có chừng chơi có độ");
        list.put(R.drawable.cd25,"Tránh vỏ dưa gặp vỏ dừa");
        list.put(R.drawable.cd26,"Đèn nhà ai nhà nấy sáng");
        list.put(R.drawable.cd27,"Tiền nào của đó");
        list.put(R.drawable.cd28,"Quýnh làm cam chịu");
        list.put(R.drawable.cd29,"Quỷ tha ma bắt");
        list.put(R.drawable.cd30,"Người đẹp vì lụa lúa tốt vì phân");
        return list;
    }

    public HashMap<Integer,String> getListSinger(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.cs1,"Bảo Anh");
        list.put(R.drawable.cs2,"Đông Nhi");
        list.put(R.drawable.cs3,"Lệ Quyên");
        list.put(R.drawable.cs4,"Văn Mai Hương");
        list.put(R.drawable.cs5,"Quang Dũng");
        list.put(R.drawable.cs6,"Miu Lê");
        list.put(R.drawable.cs7,"Lam Trường");
        list.put(R.drawable.cs8,"Hồ Ngọc Hà");
        list.put(R.drawable.cs9,"Đan Trường");
        list.put(R.drawable.cs10,"Phương Thanh");
        list.put(R.drawable.cs11,"Trần Lập");
        list.put(R.drawable.cs12,"Mỹ Tâm");
        list.put(R.drawable.cs13,"Hồng Nhung");
        list.put(R.drawable.cs14,"Hari Won");
        list.put(R.drawable.cs15,"Minh Hằng");
        list.put(R.drawable.cs16,"Khánh Linh");
        list.put(R.drawable.cs17,"Dương Triệu Vũ");
        list.put(R.drawable.cs18,"Quang Hà");
        list.put(R.drawable.cs19,"Trung Hậu");
        list.put(R.drawable.cs20,"Y Phụng");
        list.put(R.drawable.cs21,"Cao Thái Sơn");
        list.put(R.drawable.cs22,"Wanbi Tuấn Anh");
        list.put(R.drawable.cs23,"Hương Lan");
        list.put(R.drawable.cs24,"Võ Trọng Phúc");
        list.put(R.drawable.cs25,"Thu Minh");
        list.put(R.drawable.cs26,"Sơn Tùng MTP");
        list.put(R.drawable.cs27,"Thủy Tiên");
        list.put(R.drawable.cs28,"Trần Thu Hà");
        list.put(R.drawable.cs29,"Tóc Tiên");
        list.put(R.drawable.cs30,"Phạm Hồng Phúc");
        list.put(R.drawable.cs31,"Thanh Duy");
        list.put(R.drawable.cs32,"Tuấn Hưng");
        list.put(R.drawable.cs33,"Hồ Quang Hiếu");
        list.put(R.drawable.cs34,"Đoàn Thùy Trang");
        list.put(R.drawable.cs35,"Uyên Linh");
        list.put(R.drawable.cs36,"Đức Tuấn");
        list.put(R.drawable.cs37,"Thanh Thảo");
        list.put(R.drawable.cs38,"Hương Tràm");
        list.put(R.drawable.cs39,"Trung Quân");
        list.put(R.drawable.cs40,"Cẩm Ly");
        list.put(R.drawable.cs41,"Tiên Tiên");
        list.put(R.drawable.cs42,"Mỹ Linh");
        list.put(R.drawable.cs43,"Hiền Thục");
        list.put(R.drawable.cs44,"Isaac");
        list.put(R.drawable.cs45,"Noo Phước Thịnh");
        list.put(R.drawable.cs46,"Ngô Thanh Vân");
        list.put(R.drawable.cs47,"Đàm Vĩnh Hưng");
        list.put(R.drawable.cs48,"Thanh Ngọc");
        list.put(R.drawable.cs49,"Đoan Trang");
        list.put(R.drawable.cs50,"Thu Phương");
        return list;
    }

    public HashMap<Integer,String> getListComic(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.ct1,"Lạc Long Quân Âu Cơ");
        list.put(R.drawable.ct2,"Từ Thức Gặp Tiên");
        list.put(R.drawable.ct3,"Ả Chức Chàng Ngưu");
        list.put(R.drawable.ct4,"Cây Vú Sữa");
        list.put(R.drawable.ct5,"Đồng Tiền Vạn Lịch");
        list.put(R.drawable.ct6,"Chử Đồng Tử Tiên Dung");
        list.put(R.drawable.ct7,"Miếng Trầu Kỳ Diệu");
        list.put(R.drawable.ct8,"Sự Tích Con Muỗi");
        list.put(R.drawable.ct9,"Sơn Tinh Thủy Tinh");
        list.put(R.drawable.ct10,"Nợ Duyên Trong Mộng");
        list.put(R.drawable.ct11,"Sự Tích Dã Tràng");
        list.put(R.drawable.ct12,"Sự Tích Cây Khế");
        list.put(R.drawable.ct13,"Sọ Dừa");
        list.put(R.drawable.ct14,"Thánh Gióng");
        list.put(R.drawable.ct15,"Mỵ Châu Trọng Thủy");
        list.put(R.drawable.ct16,"Sự Tích Chim Quốc");
        list.put(R.drawable.ct17,"Tấm Cám");
        list.put(R.drawable.ct18,"Sự Tích Con Sam");
        list.put(R.drawable.ct19,"Thạch Sanh");
        list.put(R.drawable.ct20,"Bánh Chưng Bánh Dầy");
        list.put(R.drawable.ct21,"Sự Tích Chú Cuội");
        list.put(R.drawable.ct22,"Sự Tích TRầu Cau");
        list.put(R.drawable.ct23,"Sự Tích Hồ Gươm");
        list.put(R.drawable.ct24,"Cậu bé Tích Chu");
        list.put(R.drawable.ct25,"Hoàng Tử Ếch");
        list.put(R.drawable.ct26,"Bạch Tuyết");
        list.put(R.drawable.ct27,"Công Chúa Ngủ Trong Rừng");
        list.put(R.drawable.ct28,"Lọ Lem");
        list.put(R.drawable.ct29,"Cô Bé Quàng Khăn Đỏ");
        list.put(R.drawable.ct30,"Công Chúa Tóc Dài");
        return list;
    }

    public HashMap<Integer,String> getListCinema(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.da1,"Ninja Rùa");
        list.put(R.drawable.da2,"Bộ tứ siêu đẳng");
        list.put(R.drawable.da3,"Thiên nga đen");
        list.put(R.drawable.da4,"Harry Poter");
        list.put(R.drawable.da5,"Điệp viên 007");
        list.put(R.drawable.da6,"Trò chơi sinh tử");
        list.put(R.drawable.da7,"Kẻ cướp lăng mộ");
        list.put(R.drawable.da8,"Người đàn bà đẹp");
        list.put(R.drawable.da9,"Dị biệt");
        list.put(R.drawable.da10,"Xin Chào Việt Nam");
        list.put(R.drawable.da11,"Người Chim");
        list.put(R.drawable.da12,"Titanic");
        list.put(R.drawable.da13,"The Avengers");
        list.put(R.drawable.da14,"Cô dâu báo thù");
        list.put(R.drawable.da15,"Brokback Mountain");
        list.put(R.drawable.da16,"Nhiệm vụ bất khả thi");
        list.put(R.drawable.da17,"Forrest Gump");
        list.put(R.drawable.da18,"Kẻ hủy diệt");
        list.put(R.drawable.da19,"Tiên Hắc Ám");
        list.put(R.drawable.da20,"Em là bà nội của anh");
        list.put(R.drawable.da21,"Chàng trai năm ấy");
        list.put(R.drawable.da22,"Ngày nảy ngày nay");
        list.put(R.drawable.da23,"Để mai tính");
        list.put(R.drawable.da24,"Tôi thấy hoa vàng trên cỏ xanh");
        list.put(R.drawable.da25,"Cô dâu đại chiến");
        list.put(R.drawable.da26,"Chúa tể chiếc nhẫn");
        list.put(R.drawable.da27,"50 sắc thái");
        list.put(R.drawable.da28,"Fast and Furious");
        list.put(R.drawable.da29,"Justice League");
        list.put(R.drawable.da30,"Người tình");
        list.put(R.drawable.da31,"Star Wars");
        list.put(R.drawable.da32,"Inside out");
        list.put(R.drawable.da33,"Avatar");
        list.put(R.drawable.da34,"Vào miền hoang dã");
        list.put(R.drawable.da35,"Người nhện");
        list.put(R.drawable.da36,"Di sản tron");
        list.put(R.drawable.da37,"Gia đình siêu nhân");
        list.put(R.drawable.da38,"Định lý vạn vật");
        list.put(R.drawable.da39,"Mỹ nhân kế");
        list.put(R.drawable.da40,"Cánh đồng bất tận");

        return list;
    }
    public HashMap<Integer,String> getListFood(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.at1,"Phá lấu");
        list.put(R.drawable.at2,"Lẩu hải sản");
        list.put(R.drawable.at3,"Bánh mì");
        list.put(R.drawable.at4,"Bún bò Huế");
        list.put(R.drawable.at5,"Bún riêu");
        list.put(R.drawable.at6,"Bún thịt nướng");
        list.put(R.drawable.at7,"Bánh canh chả cá");
        list.put(R.drawable.at8,"Bún măng vịt");
        list.put(R.drawable.at9,"Bún thang");
        list.put(R.drawable.at10,"Bún mắm");
        list.put(R.drawable.at11,"Hủ tiếu nam vang");
        list.put(R.drawable.at12,"Phở");
        list.put(R.drawable.at13,"Cơm hến");
        list.put(R.drawable.at14,"Cơm tấm");
        list.put(R.drawable.at15,"Cơm gà");
        list.put(R.drawable.at16,"Cơm gà xối mỡ");
        list.put(R.drawable.at17,"Cơm lam");
        list.put(R.drawable.at18,"Mì Quảng");
        list.put(R.drawable.at19,"Bánh tráng trộn");
        list.put(R.drawable.at20,"Thịt kho trứng");
        list.put(R.drawable.at21,"Canh khổ qua");
        list.put(R.drawable.at22,"Cơm chiên dương châu");
        list.put(R.drawable.at23,"Bắp xào");
        list.put(R.drawable.at24,"Bánh ướt");
        list.put(R.drawable.at25,"Bánh hỏi");
        list.put(R.drawable.at26,"Bánh bèo");
        list.put(R.drawable.at27,"Bánh bột lọc");
        list.put(R.drawable.at28,"Bánh bò");
        list.put(R.drawable.at29,"Bánh xèo");
        list.put(R.drawable.at30,"Chả bò");
        return list;
    }
    public HashMap<Integer,String> getListCartoon(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.hh1,"Doraemon");
        list.put(R.drawable.hh2,"Larva");
        list.put(R.drawable.hh3,"Totoro");
        list.put(R.drawable.hh4,"Up");
        list.put(R.drawable.hh5,"Hãy đợi đấy");
        list.put(R.drawable.hh6,"Naruto");
        list.put(R.drawable.hh7,"Pokemon");
        list.put(R.drawable.hh8,"7 anh em hồ lô");
        list.put(R.drawable.hh9,"Thám tử Connan");
        list.put(R.drawable.hh10,"7 viên ngọc rồng");
        list.put(R.drawable.hh11,"Nữ hoàng băng giá");
        list.put(R.drawable.hh12,"Thủy thủ mặt trăng");
        list.put(R.drawable.hh13,"Thủy thủ Popeye");
        list.put(R.drawable.hh14,"Aladin và đèn thần");
        list.put(R.drawable.hh15,"Chú chó Snoopy");
        list.put(R.drawable.hh16,"Mr Bean");
        list.put(R.drawable.hh17,"Marsupilami");
        list.put(R.drawable.hh18,"Lucky Luke");
        list.put(R.drawable.hh19,"Cuộc phiêu lưu của Tin Tin");
        list.put(R.drawable.hh20,"3 nữ Thám tử");
        list.put(R.drawable.hh21,"Cô bé lọ lem");
        list.put(R.drawable.hh22,"Bạch Tuyết và 7 chú lùn");
        list.put(R.drawable.hh23,"Giai nhân và Quái vật");
        list.put(R.drawable.hh24,"Hoa Mộc Lan");
        list.put(R.drawable.hh25,"Công Chúa Dũng Cảm");
        list.put(R.drawable.hh26,"Pocahontas");
        list.put(R.drawable.hh27,"Nàng tiên cá");
        list.put(R.drawable.hh28,"Cậu bé người gỗ");
        list.put(R.drawable.hh29,"Tôn ngộ không");
        list.put(R.drawable.hh30,"Đảo HẢi Tặc");
        return list;
    }

    public HashMap<Integer,String> getListFamous(){
        HashMap<Integer,String> list = new HashMap<Integer,String>();
        list.put(R.drawable.nt1, "Jonny Depp");
        list.put(R.drawable.nt2, "Brad Pitt");
        list.put(R.drawable.nt3, "Paul Walker");
        list.put(R.drawable.nt4, "Leo Dicaprio");
        list.put(R.drawable.nt5, "Heath Ledger");
        list.put(R.drawable.nt6, "Jennifer Lawrence");
        list.put(R.drawable.nt7, "Kristen Stewart");
        list.put(R.drawable.nt8, "Angela Jolie");
        list.put(R.drawable.nt9, "Nicole Kidman");
        list.put(R.drawable.nt10, "Marilyn Monroe");
        list.put(R.drawable.nt11, "Taylor Swift");
        list.put(R.drawable.nt12, "Beyone Knowles");
        list.put(R.drawable.nt13, "Katy Perry");
        list.put(R.drawable.nt14, "Nicki Minaj");
        list.put(R.drawable.nt15, "PSY");
        list.put(R.drawable.nt16, "Nguyễn Bá Thanh");
        list.put(R.drawable.nt17, "Hoài Linh");
        list.put(R.drawable.nt18, "Việt Hương");
        list.put(R.drawable.nt19, "Tim Cook");
        list.put(R.drawable.nt21, "Mark Zuckerberg");
        list.put(R.drawable.nt22, "Bill Gates");
        list.put(R.drawable.nt23, "Bill Clinton");
        list.put(R.drawable.nt24, "Hilary Clinton");
        list.put(R.drawable.nt25, "Kofi Annan");
        list.put(R.drawable.nt26, "Ban Ki Moon");
        list.put(R.drawable.nt27, "JK. Rowling");
        list.put(R.drawable.nt28, "Nam Phương Hoàng Hậu");
        list.put(R.drawable.nt29, "Hồ Chí Minh");
        list.put(R.drawable.nt30, "Trịnh Công Sơn");

        return list;
    }

    public HashMap<Integer,HashMap<Integer,String>> getAllImage(){
        HashMap<Integer,HashMap<Integer,String>> listHashMap = new HashMap<Integer,HashMap<Integer,String>>();
        List<Integer> listMenu = getListMenu();
        listHashMap.put(R.drawable.animal,getListAnimal());
        listHashMap.put(R.drawable.sport,getListSport());
        listHashMap.put(R.drawable.mobileapp,getListMobileApp());
        listHashMap.put(R.drawable.cadao,getListCadao());
        listHashMap.put(R.drawable.truyencotich,getListComic());
        listHashMap.put(R.drawable.cartoon,getListCartoon());
        listHashMap.put(R.drawable.cinema,getListCinema());
        listHashMap.put(R.drawable.singer,getListSinger());
        listHashMap.put(R.drawable.famous,getListFamous());
        listHashMap.put(R.drawable.food,getListFood());

        return listHashMap;

    }
}
