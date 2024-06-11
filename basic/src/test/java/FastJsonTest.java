import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author 熊乾坤
 * @since 2019-11-28 15:35
 */
public class FastJsonTest {
    public static void main(String[] args) {
        //B b=new B();
        //b.setSex("男");
        //b.setName("xqk");
        //System.out.println(JSON.toJSONString(b));
        //
        //Byte c=null;
        //System.out.println(2==c);

        //HashSet<String> set1=new HashSet<>();
        //HashSet<String> set2=new HashSet<>();
        //
        //set1.add("1");
        //set1.add("2");
        //set1.add("3");
        //set2.add("2");
        //set2.add("3");
        //set2.add("4");
        //set1.retainAll(set2);
        //System.out.println(String.join(",", set1));
        //
        //Long l=1L;
        //System.out.println(l.equals(null));

        //Set<DispositionInfoVO> dispositionInfoVos = new HashSet<>();
        //DispositionInfoVO vo=new DispositionInfoVO();
        //vo.setDispositionLevel((byte) 0);
        //vo.setDispositionType("1");
        //
        //DispositionInfoVO vo2=new DispositionInfoVO();
        //vo2.setDispositionLevel((byte) 1);
        //vo2.setDispositionType("2");
        //
        //DispositionInfoVO vo3=new DispositionInfoVO();
        //vo3.setDispositionLevel((byte) 3);
        //vo3.setDispositionType("4");
        //
        //dispositionInfoVos.add(vo);
        //dispositionInfoVos.add(vo2);
        //dispositionInfoVos.add(vo3);
        //System.out.println(dispositionInfoVos);

        //Byte b=2;
        //Byte a = null;
        //System.out.println(b > a);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "1");
        hashMap.put("3", "1");
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.equals("2")) {
                iterator.remove();
            }
            if (key.equals("3")) {
                iterator.remove();
            }
        }
        System.out.println(hashMap);
    }

    @Data
    public static class A {
        private String name;
    }

    @Data
    public static class B extends A {
        private String sex;
    }

    @Data
    public static class DispositionInfoVO implements Comparable<DispositionInfoVO> {
        private String dispositionType;
        private Byte dispositionSource;
        private Byte dispositionLevel;
        private String dispositionTitle;
        @JSONField(format = "yyyy-MM-dd HH:mm")
        private Date startDateTime;
        @JSONField(format = "yyyy-MM-dd HH:mm")
        private Date endDateTime;

        @Override
        public int compareTo(DispositionInfoVO o) {
            if (o == null || o.getDispositionLevel() == null) {
                return -1;
            }

            return o.getDispositionLevel().compareTo(dispositionLevel);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            DispositionInfoVO that = (DispositionInfoVO) o;
            return dispositionType != null && dispositionType.equals(that.getDispositionType());
        }

        @Override
        public int hashCode() {
            return Objects.hash(dispositionType);
        }
    }

}
