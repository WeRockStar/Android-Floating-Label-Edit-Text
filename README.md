#### XML Code
    <android.support.design.widget.TextInputLayout
            android:id="@+id/inputUsernameLayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <EditText
                android:id="@+id/edtUsername"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="username" />

    </android.support.design.widget.TextInputLayout>
#### build.gradle
```java
    compile 'com.android.support:design:23.0.1'
```