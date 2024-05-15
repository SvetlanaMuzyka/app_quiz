package com.example.project1702.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.project1702.Adapter.LeaderAdapter
import com.example.project1702.Domain.UserModel
import com.example.project1702.R
import com.example.project1702.databinding.ActivityLeaderBinding

class LeaderActivity : AppCompatActivity() {
    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@LeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LeaderActivity, R.color.on_prim_cont)


        binding.apply {
            scoreTop1Txt.text = loadData().get(0).score.toString()
            scoreTop2Txt.text = loadData().get(1).score.toString()
            scoreTop3Txt.text = loadData().get(2).score.toString()
            titleTop1Txt.text = loadData().get(0).name
            titleTop2Txt.text = loadData().get(1).name
            titleTop3Txt.text = loadData().get(2).name

            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)

            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)

            val drawableResourceId3: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)


            bottomMenu.setItemSelected(R.id.Board)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.home) {
                    startActivity(Intent(this@LeaderActivity, MainActivity::class.java))
                }
            }

            var list: MutableList<UserModel> = loadData()
            list.removeAt(2)
            list.removeAt(1)
            list.removeAt(0)
            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }
    }

    // API
    private fun loadData(): MutableList<UserModel> {
        val users: MutableList<UserModel> = mutableListOf()

        users.add(UserModel(1, "Person1", "persson_1", 4850))
        users.add(UserModel(2, "Person2", "persson_2", 4850))
        users.add(UserModel(3, "Tanya", "persson_3", 4850))


        users.add(UserModel(4, "Lily Black", "persson_1", 4560))
        users.add(UserModel(5, "Cat", "persson_3", 3873))
        users.add(UserModel(6, "Maks", "persson_1", 3250))
        users.add(UserModel(7, "Alex", "persson_2", 3015))
        users.add(UserModel(8, "Somebody", "persson_3", 2970))
        users.add(UserModel(9, "Sarah", "persson_1", 2870))

        return users
    }
}