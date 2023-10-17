package com.example.bitfitp1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfitp1.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch


private const val TAG = "MainActivity/"

class MainActivity : AppCompatActivity() {
    private lateinit var sleepRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val sleeps = mutableListOf<DisplaySleep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sleepRecyclerView = findViewById<RecyclerView>(R.id.list)
        val sleepAdapter = SleepAdapter(this, sleeps)

        sleepRecyclerView.adapter = sleepAdapter
        sleepRecyclerView.layoutManager = LinearLayoutManager(this).also{
            val dividerItemDecoration = DividerItemDecoration(this, 0)
            sleepRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        var avgFeelingTV = findViewById<TextView>(R.id.avgFeelingTextView)
        var avgHoursTV = findViewById<TextView>(R.id.avgHoursTextView)

        //this is pretty bad, but it works!
        lifecycleScope.launch {
            val sleepDao = (application as SleepApplication).db.SleepDao()
            val avgFeeling = sleepDao.getFeelingAvg().firstOrNull() ?: 0.0
            val avgHours = sleepDao.getHoursAvg().firstOrNull() ?: 0.0

            avgFeelingTV.text = avgFeeling.toString()
            avgHoursTV.text = avgHours.toString()
        }


        var addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            sleepAdapter.notifyDataSetChanged()
            val intent = Intent(this, SleepActivity::class.java)
            this.startActivity(intent)

            //this is pretty bad, but it works!
            lifecycleScope.launch {
                val sleepDao = (application as SleepApplication).db.SleepDao()
                val avgFeeling = sleepDao.getFeelingAvg().firstOrNull() ?: 0.0
                val avgHours = sleepDao.getHoursAvg().firstOrNull() ?: 0.0

                avgFeelingTV.text = avgFeeling.toString()
                avgHoursTV.text = avgHours.toString()
            }
        }



        lifecycleScope.launch {
            (application as SleepApplication).db.SleepDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplaySleep(
                        entity.date,
                        entity.feeling.toString(),
                        entity.hours.toString(),
                        entity.notes,
                    )
                }.also { mappedList ->
                    sleeps.clear()
                    sleeps.addAll(mappedList)
                    sleepAdapter.notifyDataSetChanged()
                }
            }
        }

    }
}