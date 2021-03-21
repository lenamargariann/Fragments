package com.screen.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FragmentFirst()
        val secondFragment = FragmentSecond()
        val buttonAdd: Button = findViewById(R.id.button)
        val buttonReplace: Button = findViewById(R.id.button2)
        val buttonRemove: Button = findViewById(R.id.button3)
        var k = 0

            buttonReplace.setOnClickListener {
                if (k == 0) {
                    k = 1
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.FirstFragment, secondFragment)
                        commit()
                    }
                } else if (k == 1) {
                    k = 0
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.FirstFragment, firstFragment)
                        commit()
                    }
                }
            }
        buttonAdd.setOnClickListener {
            if (k == 0) {
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.FirstFragment, secondFragment)
                    commit()
                    k = 1
                }
            } else {
                k = 0
                supportFragmentManager.beginTransaction().apply {
                    add(R.id.FirstFragment, firstFragment)
                    commit()
                }
            }
        }
                buttonRemove.setOnClickListener {
                    if (k == 1) {
                        k = 0
                        supportFragmentManager.beginTransaction().apply {
                            remove(secondFragment)
                            commit()
                        }
                    } else if( k == 0)
                    {
                        supportFragmentManager.beginTransaction().apply {
                            remove(firstFragment)
                            commit()
                        }
                    }
                }

        }
    }