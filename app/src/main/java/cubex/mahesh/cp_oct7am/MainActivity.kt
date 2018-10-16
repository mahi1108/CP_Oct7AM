package cubex.mahesh.cp_oct7am

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var resolver = contentResolver
        var c = resolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
// Context context, int layout, Cursor c, String[] from, int[] to, int flags
    var from = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER)
    var to = intArrayOf(R.id.tv1,R.id.tv2)

        var adapter = SimpleCursorAdapter(this@MainActivity,
                R.layout.indiview,c,from,to,0)
        lview.adapter = adapter

        srch.setOnClickListener {

            var c = resolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+"=?",
                    arrayOf(et1.text.toString()),
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
// Context context, int layout, Cursor c, String[] from, int[] to, int flags
            var from = arrayOf(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER)
            var to = intArrayOf(R.id.tv1,R.id.tv2)

            var adapter = SimpleCursorAdapter(this@MainActivity,
                    R.layout.indiview,c,from,to,0)
            lview.adapter = adapter

        }
    }
}

/*
 *   @SuppressLint("MissingPermission")
    fun readCallLog( )
    {
        var resolver = contentResolver
        var c =  resolver.query(
                CallLog.Calls.CONTENT_URI,
                null,null,null,
                null)
        var calllog_list = mutableListOf<CallLogBean>()
        while (c.moveToNext()){
            var name_col_index =   c.getColumnIndex(
                    CallLog.Calls.CACHED_NAME)
            var number_col_index =   c.getColumnIndex(
                    CallLog.Calls.NUMBER)
            var date_index = c.getColumnIndex(
                    CallLog.Calls.DATE)
            var call_type_index = c.getColumnIndex(
                    CallLog.Calls.TYPE)
            var call_duration_index = c.getColumnIndex(
                    CallLog.Calls.DURATION)

            var name = c.getString(name_col_index)
            var number = c.getString(number_col_index)
            var date = c.getString(date_index)
            var type = c.getString(call_type_index)
            var duration = c.getString(call_duration_index)
            calllog_list.add(CallLogBean(name,number,date,
                    type,duration))
        }
        if(calllog_list.size>0) {
            var uid = FirebaseAuth.getInstance().uid
            var dBase = FirebaseDatabase.getInstance().getReference(uid!!)
            var calllog_ref = dBase.child("calllog")
            for(log in calllog_list){
                var unique_id = calllog_ref.push()
                unique_id.child("name").setValue(log.name)
                unique_id.child("number").setValue(log.number)
                unique_id.child("date").setValue(log.date)
                unique_id.child("type").setValue(log.type)
                unique_id.child("duration").setValue(log.duration)
            }
        }
    }
    fun readSMS( )
    {
        var resolver = contentResolver
        var c =  resolver.query(
                Uri.parse("content://sms/inbox"),
                null,null,null,
                null)
        var msgs_list = mutableListOf<MessageBean>()
        while (c.moveToNext()){
            var from =  c.getString(2)
            var msg_body = c.getString(11)
            msgs_list.add(MessageBean(from,msg_body))
        }

        if(msgs_list.size>0) {
            var uid = FirebaseAuth.getInstance().uid
            var dBase = FirebaseDatabase.getInstance().getReference(uid!!)
            var msg_ref = dBase.child("messages")
            for(msg in msgs_list)
            {
                var unique_id = msg_ref.push()
                unique_id.child("number").setValue(msg.number)
                unique_id.child("msg_body").setValue(msg.msg_body)
            }
        }
    } */
