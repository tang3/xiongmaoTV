package com.example.mypanda.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 红超 on 2017/2/15.
 */

public class MySupViewPage extends ViewPager {


    public MySupViewPage(Context context) {
        super(context);
        init();
    }

    private void init() {
        addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == SCROLL_STATE_IDLE) {
                    handler.sendEmptyMessageDelayed(100, 3000);
                } else if (state == SCROLL_STATE_SETTLING) {
                    handler.removeCallbacksAndMessages(null);

                }
            }
        });
    }

    private static final String TAG = "MySupViewPage";
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 100) {
                Log.e(TAG, "handleMessage: ==========="+views.size() );
                int currentItem = getCurrentItem();
                setCurrentItem(++currentItem);
                Log.e(TAG, "handleMessage: ==========="+currentItem );
                handler.sendEmptyMessageDelayed(100, 3000);
            }
            return true;
        }
    });

    List<View> views = new ArrayList<>();

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ImageView view = (ImageView) getAdapter().instantiateItem(null, i);
            if (view!=null)
            if (views.contains(view)) {
                if (views.size() == 1) {

                    views.addAll(views);
                    views.addAll(views);


                    Log.e(TAG, "setAdapter: 添加了数据"+views.size() );
                } else if (views.size() == 2) {
                    views.addAll(views);

                    Log.e(TAG, "setAdapter: "+views.size() );

                }
                break;
            } else {
                views.add(view);
            }


        }


    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        handler.sendEmptyMessageDelayed(100, 3000);
    }


    @Override
    protected void onDetachedFromWindow() {
        Log.e(TAG, "onDetachedFromWindo============w: handlerquxiao" );
        handler.removeCallbacksAndMessages(null);

        super.onDetachedFromWindow();
    }

    public MySupViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }



//    private SuperViewPager.OnItemClickListener listener;
//    private boolean isDrag;
//
//    public MySupViewPage(Context context) {
//        super(context);
//        init();
//    }
//
//    private boolean isLoop = true;
//    public List<View> list = new ArrayList<>();
//
//    public void setLoop(boolean isLoop) {
//        this.isLoop = isLoop;
//    }
//
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
////            getAdapter().getCount();
//            if (list.size() == 0) return;
//            // 刚才那个是反复添加了
//            //0 1 2 3 0 1 2 3(错误)
//            // 0 1 2 3 4 5 6 7....
//            int i = getCurrentItem() + 1;
//            if (i >= getAdapter().getCount()) {
//                i = 0;
//            }
//            setCurrentItem(i);
//            handler.sendEmptyMessageDelayed(0, 3000);
//        }
//    };
//
//    @Override
//    public void setAdapter(final PagerAdapter adapter) {
//        super.setAdapter(adapter);
//        handleViews(adapter);
//        handlerListener();
//    }
//
//    private void handlerListener() {
//        for (int i = 0; i < list.size(); i++) {
//            final View view = list.get(i);
//            final int finalI = i;
//            view.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null) {
//                        listener.onItemClickListener(MySupViewPage.this, view, finalI);
//                    }
//                }
//            });
//        }
//    }
//
//    private void handleViews(PagerAdapter adapter) {
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            View o = (View) adapter.instantiateItem(null, i);
//            if (list.contains(o)) {
//                return;
//            } else {
//                // 导致list一直0.
//                list.add(o);
//            }
//
//        }
//    }
//
//
//    public MySupViewPage(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    private void init() {
////        setOnPageChangeListener();
//        addOnPageChangeListener(new OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                if (state == SCROLL_STATE_DRAGGING) {
//                    isDrag = true;
//                    handler.removeCallbacksAndMessages(null);
//                } else if (state == SCROLL_STATE_IDLE && isDrag) {
//                    isDrag = false;
//                    ;
//                    handler.sendEmptyMessageDelayed(0, 3000);
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        startLooper();
//    }
//
//    private void startLooper() {
//        if (list.size() > 0 && isLoop)
//            handler.sendEmptyMessageDelayed(0, 3000);
//    }
//
//    @Override
//    protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//
//        handler.removeCallbacksAndMessages(null);
//    }
//
//
//    public interface OnItemClickListener {
//        void onItemClickListener(ViewPager pager, View view, int position);
//    }
//
//    public void setOnItemClickListener(SuperViewPager.OnItemClickListener clickListener) {
//        this.listener = clickListener;
//    }
//    public void stopLooper(){
//        handler.removeCallbacksAndMessages(null);
//    }
//    public void startLoop(){
//        handler.sendEmptyMessageDelayed(0,3000);
//    }


}
