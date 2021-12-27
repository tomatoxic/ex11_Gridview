package com.example.ex11_gridview;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    // 영화 포스터 이미지
    Integer[] posterID = {
            R.drawable.mov01, R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
            R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
            R.drawable.mov11, R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,
            R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20,
            R.drawable.mov21, R.drawable.mov22,R.drawable.mov23,R.drawable.mov24,R.drawable.mov25,
            R.drawable.mov26,R.drawable.mov27,R.drawable.mov28,R.drawable.mov29,R.drawable.mov30
//            R.drawable.mov31, R.drawable.mov32,R.drawable.mov33,R.drawable.mov44,R.drawable.mov45,
//            R.drawable.mov36,R.drawable.mov37,R.drawable.mov38,R.drawable.mov49,R.drawable.mov50,
//            R.drawable.mov41, R.drawable.mov42,R.drawable.mov43,R.drawable.mov54,R.drawable.mov55,
//            R.drawable.mov46,R.drawable.mov47,R.drawable.mov48,R.drawable.mov59,R.drawable.mov60,
//            R.drawable.mov61
    };

    // 포스터 제목
    String[] posterName ={
            "써니","완득이","괴물","라디오 스타",
            "비열한 거리","왕의 남자","아일랜드", "웰컴 투 동막골",
            "헬보이","백 투더 퓨쳐","여인의 향기","쥬라기 공원",
            "포레스트 검프","사랑의 블랙홀","혹성탈출 : 진화의 시작","아름다운 비행",
            "내 이름은 칸","해리포터 : 죽음의 성물","마더","킹콩을 들다",
            "쿵푸팬더 2","짱구는 못말려 극장판","아저씨","아바타",
            "대부","국가대표","토이스토리 3","마당을 나온 암탉",
            "죽은 시인의 사회","서유쌍기"
    };

    public class MyGridAdapter extends BaseAdapter{

        Context context, title;

        public MyGridAdapter(Context c){
            context = c; // 컨텍스트 변수를 다른 메소드에서 사용하기 위해 정의
        }

        // getCount : 그리드뷰에 보여질 이미지의 개수
        public int getCount(){
            return posterID.length; // 포스터 이미지 배열의 길이만큼
        }

        public Object getItem(int arg0){
            return null;
        }

        public long getItemId(int arg0) {
            return 0;
        }

        // getView : 영화 포스터를 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주게 함
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            // 메인화면에서 그리드안의 포스터 크기 설정

            imageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            // 그리드안에서 정렬 위치 (FIT_위치)
            // FIT_CENTER : 가운데 정렬
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            // 상하좌우 여백
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]);

            final int pos = position;

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);

                    // 이미지뷰의 이미지 리소스
                    ivPoster.setImageResource(posterID[pos]);
                    // 제목 설정
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });
            return imageView;
        }

    }


}