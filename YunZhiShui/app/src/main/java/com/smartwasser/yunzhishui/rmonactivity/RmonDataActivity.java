package com.smartwasser.yunzhishui.rmonactivity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;
import com.smartwasser.yunzhishui.bean.BuildingResponse;
import com.smartwasser.yunzhishui.bean.BusinessUnitResponse;
import com.smartwasser.yunzhishui.bean.EventNormSelect;
import com.smartwasser.yunzhishui.bean.QuotaResponse;
import com.smartwasser.yunzhishui.bean.RBResponse;
import com.smartwasser.yunzhishui.bean.RmonSelectResponse;
import com.smartwasser.yunzhishui.net.HttpLoader;
import com.smartwasser.yunzhishui.utils.ConstantsYunZhiShui;
import com.smartwasser.yunzhishui.utils.DialogTimeUtils;
import com.smartwasser.yunzhishui.utils.PopListViewUtils;
import com.smartwasser.yunzhishui.utils.PopupWindowUtils;
import com.smartwasser.yunzhishui.utils.TimeUtils;

import org.seny.android.utils.MyToast;

import java.util.HashMap;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by huangmengjie on 2016/7/30 0030.
 */
public class RmonDataActivity extends BaseActivity implements View.OnClickListener,HttpLoader.ResponseListener{
    private ImageButton button_fan,image_add,image_serc;
    private TextView tv_toolbar_zhu,tv_toolbar_centext;
    private ImageButton xiala;
    private RelativeLayout relat;
    private ImageButton image_zxt,image_xj;
    private int i=1;
    private RmonSelectResponse mRmon;
    private ListView rmon_list;
    private MyAdapter myAdapter;
    private EventNormSelect event;
    private TextView  title;
    private EditText ed_rmon_dw,ed_rmon_gzw,ed_rmon_zb
            ,ed_muchtrend_strattime,ed_muchtrend_endtime
            ,ed_kuaijie_muchtime;
    private ImageButton image_rmon_dw,image_rmon_gzw,
            image_rmon_zb, but_muchtrend_strattime
            ,but_end_time,image_kuaijie;
    private ListView minitListView2,
            minitListView5,minitListView6,minitListView7;


    private TimeUtils time=new TimeUtils();
    private BusinessUnitResponse mBusinessUnit;
    private MyBusinesAdapter myBusinesAdapter;
    private String code="";
    private BuildingResponse mBuilding;
    private  MyBuildingAdapter myBuildingAdapter;
    private String buildCode="";
    private QuotaResponse mQuota;
    private MyQuotaAdapter myQuotaAdapter;
    private String indeCode="";
    private DialogTimeUtils dialog=new DialogTimeUtils(this);
    private PopListViewUtils plu=new PopListViewUtils(this);
    @Override
    protected int initContentView() {
        return R.layout.activity_rmon_result_state2;
    }
    @Override
    protected void initView() {
        button_fan= (ImageButton) findViewById(R.id.button_fan);
        button_fan.setBackgroundResource(R.drawable.fanhu);
        image_add= (ImageButton) findViewById(R.id.image_add);
        image_serc= (ImageButton) findViewById(R.id.image_serc);
        image_add.setVisibility(View.GONE);
        tv_toolbar_zhu= (TextView) findViewById(R.id.tv_toolbar_zhu);
        tv_toolbar_centext= (TextView) findViewById(R.id.tv_toolbar_centext);
        xiala= (ImageButton) findViewById(R.id.xiala);
        relat= (RelativeLayout) findViewById(R.id.relat_shi);
        image_zxt= (ImageButton) findViewById(R.id.image_zxt);
        image_xj= (ImageButton) findViewById(R.id.image_sj);
        rmon_list= (ListView)findViewById(R.id.rmon_list);
        title= (TextView) findViewById(R.id.title);


        ed_rmon_dw= (EditText) findViewById(R.id.ed_rmon_dw);
        ed_rmon_gzw= (EditText) findViewById(R.id.ed_rmon_gzw);
        ed_rmon_zb= (EditText) findViewById(R.id.ed_rmon_zb);
        ed_muchtrend_strattime= (EditText) findViewById(R.id.ed_muchtrend_strattime);
        ed_muchtrend_endtime= (EditText) findViewById(R.id.ed_muchtrend_endtime);
        ed_kuaijie_muchtime= (EditText) findViewById(R.id.ed_kuaijie_muchtime);
        image_rmon_dw= (ImageButton) findViewById(R.id.image_rmon_dw);
        image_rmon_gzw= (ImageButton) findViewById(R.id.image_rmon_gzw);
        image_rmon_zb= (ImageButton) findViewById(R.id.image_rmon_zb);
        but_muchtrend_strattime= (ImageButton) findViewById(R.id. but_muchtrend_strattime);
        but_end_time= (ImageButton) findViewById(R.id.but_end_time);
        image_kuaijie= (ImageButton) findViewById(R.id.image_kuaijie);
        EventBus.getDefault().registerSticky(this);
    }
    @Override
    protected void initListener() {
        xiala.setOnClickListener(this);
        image_zxt.setOnClickListener(this);
        image_xj.setOnClickListener(this);
        ed_rmon_dw.setOnClickListener(this);
        ed_rmon_gzw.setOnClickListener(this);
        ed_rmon_zb.setOnClickListener(this);
        ed_muchtrend_strattime.setOnClickListener(this);
        ed_muchtrend_endtime.setOnClickListener(this);
        ed_kuaijie_muchtime.setOnClickListener(this);
        image_serc.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        tv_toolbar_zhu.setText("远程监控");
        tv_toolbar_centext.setText("运行数据查询");
        button_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRmon=event.getRmon();
        title.setText(event.getUserName());
        myAdapter=new MyAdapter();
        rmon_list.setAdapter(myAdapter);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiala:
                if (i % 2 == 0) {
                    relat.setVisibility(View.GONE);
                } else {
                    relat.setVisibility(View.VISIBLE);
                }
                ++i;
                break;
            case R.id. ed_rmon_dw:
                /**单位*/
                minitListView5 = initListView5();
                PopupWindowUtils.showPopupWindow(minitListView5, ed_rmon_dw);
                break;
            case R.id.ed_rmon_gzw:
                /**构筑物*/
                String s = ed_rmon_dw.getText().toString();
                if ("".equals(s) || "null".equals(s) || s == null) {
                    Toast.makeText(RmonDataActivity.this, "请选择单位", Toast.LENGTH_SHORT).show();
                    return;
                }
                minitListView6 = initListView6();
                PopupWindowUtils.showPopupWindow(minitListView6, ed_rmon_gzw);
                break;
            case R.id.ed_rmon_zb:
                /**指标*/
                String s2 = ed_rmon_dw.getText().toString();
                if ("".equals(s2) || "null".equals(s2) || s2 == null) {
                    Toast.makeText(RmonDataActivity.this, "请选择单位", Toast.LENGTH_SHORT).show();
                    return;
                }
                String s3 = ed_rmon_gzw.getText().toString();
                if ("".equals(s3) || "null".equals(s3) || s3 == null) {
                    Toast.makeText(RmonDataActivity.this, "请选择构筑物", Toast.LENGTH_SHORT).show();
                    return;
                }
                minitListView7 = initListView7();
                PopupWindowUtils.showPopupWindow(minitListView7, ed_rmon_zb);
                break;
            case R.id.ed_muchtrend_strattime:
                /**开始时间*/
                dialog.show(ed_muchtrend_strattime);
                dialog.showTime();
                break;
            case R.id.ed_muchtrend_endtime:
                /**结束时间*/
                dialog.show(ed_muchtrend_endtime);
                dialog.showTime();
                break;
            case R.id.ed_kuaijie_muchtime:
                /**快捷时间*/
                // 初始化ListView控件和里边的数据
                minitListView2 = plu.initListView();
                PopupWindowUtils.showPopupWindow(minitListView2, ed_kuaijie_muchtime);
                minitListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        List<String> list = time.showTimeShortcut();
                        if (position >= 1) {
                            ed_muchtrend_strattime.setText(list.get(position * 2 - 2));
                            ed_muchtrend_endtime.setText(list.get(position * 2 - 1));
                            ed_kuaijie_muchtime.setText(plu.mListView.get(position));
                        }
                        /**关闭popupwindow*/
                        PopupWindowUtils.closePopupWindow();
                    }
                });
                break;
            case R.id.image_serc:
                /**发起网络请求*/


                String dw=ed_rmon_dw.getText().toString();
                if("".equals(dw)||dw==null||"null".equals(dw)){
                    Toast.makeText(RmonDataActivity.this, "请选择单位", Toast.LENGTH_SHORT).show();
                    return;
                }
                String gzw=ed_rmon_gzw.getText().toString();
                if("".equals(gzw)||gzw==null||"null".equals(gzw)){
                    Toast.makeText(RmonDataActivity.this, "请选择构筑物", Toast.LENGTH_SHORT).show();
                    return;
                }
                String sb=ed_rmon_zb.getText().toString();
                if("".equals(sb)||sb==null||"null".equals(sb)){
                    Toast.makeText(RmonDataActivity.this, "请选择设备", Toast.LENGTH_SHORT).show();
                    return;
                }
                String start=ed_muchtrend_strattime.getText().toString();
                String end=ed_muchtrend_endtime.getText().toString();
                if("".equals(start)||start==null||"null".equals(start)){
                    Toast.makeText(RmonDataActivity.this, "请选择开始时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equals(end)||end==null||"null".equals(end)){
                    Toast.makeText(RmonDataActivity.this, "请选择结束时间", Toast.LENGTH_SHORT).show();
                    return;
                }
                showProgressDialog();
                HashMap<String, Object> prams = new HashMap<>();
                prams.put("businessCode",code);
                prams.put("buildCode",buildCode);
                prams.put("indeCode",indeCode);
                prams.put("dataTimeFrom",start);
                prams.put("dataTimeTo", end);
                HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCRMONSELECT, prams,
                        RmonSelectResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCRMONSELECT, this, false).setTag(this);
                showProgressDialog();
                break;
            case R.id.image_zxt:
                EventBus.getDefault().postSticky(mRmon);
                Intent intent=new Intent(RmonDataActivity.this,SelectResultActivity.class);
                startActivity(intent);
                finish();
            break;
        }
    }
    public void onEvent(EventNormSelect event){
            this.event=event;
    }

    @Override
    public void onGetResponseSuccess(int requestCode, RBResponse response) {
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUSINESS
                && response instanceof BusinessUnitResponse) {
            mBusinessUnit= (BusinessUnitResponse) response;
            if ("00000".equals( mBusinessUnit.getErrorCode())) {
                myBusinesAdapter = new MyBusinesAdapter();
                minitListView5.setAdapter(myBusinesAdapter);
                minitListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_rmon_dw.setText(mBusinessUnit.getData().getComboboxList().get(position).getText());
                        code = mBusinessUnit.getData().getComboboxList().get(position).getId();
                        PopupWindowUtils.closePopupWindow();
                    }
                });
            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUILDING
                && response instanceof BuildingResponse) {
            mBuilding = (BuildingResponse) response;
            if ("00000".equals(mBuilding.getErrorCode())) {
                myBuildingAdapter = new MyBuildingAdapter();
                minitListView6.setAdapter( myBuildingAdapter);
                minitListView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_rmon_gzw.setText(mBuilding.getData().getComboboxList().get(position).getText());
                        buildCode = mBuilding.getData().getComboboxList().get(position).getId();
                        PopupWindowUtils.closePopupWindow();
                    }
                });

            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCQUOTA
                && response instanceof QuotaResponse) {
            mQuota = (QuotaResponse) response;
            if ("00000".equals(mQuota.getErrorCode())) {
                myQuotaAdapter = new MyQuotaAdapter();
                minitListView7.setAdapter( myQuotaAdapter);
                minitListView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ed_rmon_zb.setText( mQuota.getData().getComboboxList().get(position).getText());
                        indeCode = mQuota.getData().getComboboxList().get(position).getId();
                        PopupWindowUtils.closePopupWindow();
                    }
                });

            }
        }
        if (requestCode == ConstantsYunZhiShui.REQUEST_CODE_ZXJCRMONSELECT
                && response instanceof RmonSelectResponse) {
               mRmon= (RmonSelectResponse) response;
            if("00014".equals(mRmon.getErrorCode())){
                Toast.makeText(RmonDataActivity.this, "没有你想要查询的数据", Toast.LENGTH_SHORT).show();
                myAdapter.notifyDataSetChanged();
                title.setText(ed_rmon_zb.getText().toString());
            }
            if("00000".equals(mRmon.getErrorCode())){
                title.setText(ed_rmon_zb.getText().toString());
                myAdapter.notifyDataSetChanged();
            }
            dismissProgressDialog();
        }
    }

    @Override
    public void onGetResponseError(int requestCode, VolleyError error) {
        MyToast.show(this, "error: " + error.getMessage());
    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if(mRmon.getData()==null){
                return 0;
            }
            return mRmon.getData().getDataList().size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(RmonDataActivity.this,R.layout.item_rmon,null);
                holder=new ViewHolder();
                holder.result= (TextView) convertView.findViewById(R.id.result);
                holder.xuhao= (TextView) convertView.findViewById(R.id.xuhao);
                holder.times= (TextView) convertView.findViewById(R.id.times);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            if(mRmon.getData()!=null) {
                if((mRmon.getData().getDataList().get(position)+"").equals("1")){
                    holder.result.setText("运行");
                }else{
                    holder.result.setText("停止");
                }
                holder.xuhao.setText(position + "");
                holder.times.setText(mRmon.getData().getDateArray().get(position));
            }
            return convertView;
        }
        class ViewHolder{
            TextView result,xuhao,times;
        }
    }
    private ListView initListView7(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("businessCode",code);
        prams.put("buildCode",buildCode);
        prams.put("dataType2","D1");
        HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCQUOTA, prams,
                QuotaResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCQUOTA, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView6(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        prams.put("businessCode", code);
        HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCBUILDING, prams,
                BuildingResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUILDING, this, false).setTag(this);
        return mListViews;
    }
    private ListView initListView5(){
        ListView mListViews = new ListView(this);
        mListViews.setDividerHeight(0);
        mListViews.setBackgroundResource(R.drawable.listview_background);
        // 去掉右侧垂直滑动条
        mListViews.setVerticalScrollBarEnabled(false);
        /**发起网络请求*/
        HashMap<String, Object> prams = new HashMap<>();
        HttpLoader.get(ConstantsYunZhiShui.URL_ZXJCBUSINESS, prams,
                BusinessUnitResponse.class, ConstantsYunZhiShui.REQUEST_CODE_ZXJCBUSINESS, this, false).setTag(this);
        return mListViews;
    }
    class MyBusinesAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mBusinessUnit.getData().getComboboxList().size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(RmonDataActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mBusinessUnit.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class  MyBuildingAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mBuilding.getData().getComboboxList().size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(RmonDataActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mBuilding.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class MyQuotaAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mQuota.getData().getComboboxList().size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(RmonDataActivity.this, R.layout.item_search, null);
                holder.v_listview_item_number = (TextView) convertView.findViewById(R.id.tv_listview_item_number);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.v_listview_item_number.setTextColor(Color.GRAY);
            }
            holder.v_listview_item_number.setText(mQuota.getData().getComboboxList().get(position).getText());
            return convertView;
        }
    }
    class ViewHolder{
        TextView v_listview_item_number;
    }
}
