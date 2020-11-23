package com.example.listviewexamples.models

public class MailModel(
    var sender: String,
    var topic: String,
    var preview: String,
    var is_favorite: Boolean = false
)
{
}