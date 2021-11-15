# spring-task
1. əvvəlcə /api/test/create/studentRole post request atıb student role create etmək
2. /api/auth/create/user  post request user create etmək
```
{
    "username" : "tunaynovruz346",
    "password" : "12345678",
    "email": "tunaynovruz573@gmail.com",
    "role":["student"],
    "group_id" :1
}
```

3. /api/auth/getUserToken request atib token əldə etmək
```
{
    "username" : "tunaynovruz346",
    "password" : "12345678"
}
```

4. /api/user/1 yaranmış useri fetch etmək (headerdə token olmaq şərti ilə)
