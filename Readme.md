# TodayWidget

### 사용자 정의 위젯
* 추가하고싶은 속성 xml을 정의한다.
* 재정의하려는 위젯을 상속하여 CustomWidget 클래스를 정의한다.

### attrs.xml
````xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
<declare-styleable name="Today">
    <attr name="delimeter"></attr>
</declare-styleable>
</resources>
````

### CustomWidget
* TextView를 재정의하여 오늘 날짜를 표시하는 CustomWidget를 정의한다.
* CustomWidget은 추가된 속성 정보를 확인하고 그에 상응하는 동작을 취하도록 코딩한다.
* 여기서는 delimeter(구분자) 속성 정보를 입력받아 오늘 날짜를 사용자가 지정한 구분자를 사용하여 날짜를 출력한다.

````java
public class Today extends android.support.v7.widget.AppCompatTextView {
    public Today(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Today);
        int size = typedArray.getIndexCount();
        for (int i = 0; i < size; ++i) {
            int idx = typedArray.getIndex(i);
            switch (idx) {
                case R.styleable.Today_delimeter:
                    String delimeter = typedArray.getString(idx);
                    setToday(delimeter);
                    break;
            }
        }
    }

    private void setToday(String delimeter) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + delimeter + "MM" + delimeter + "dd");
        String today = sdf.format(date);
        setText(today);
    }
}
````