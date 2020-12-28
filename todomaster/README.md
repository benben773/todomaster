##第一阶段：基本功能
###添加 Todo 项。
todo add <item>
1. <item>
Item <itemIndex> added

###完成 Todo 项。
todo done <itemIndex>
Item <itemIndex> done.

###查看 Todo 列表，缺省情况下，只列出未完成的 Todo 项。
todo list
1. <item1>
2. <item2>
Total: 2 items

###使用 all 参数，查看所有的 Todo 项。
todo list --all
1. <item1>
2. <item2>
3. [Done] <item3>

###Total: 3 items, 1 item done
要求：
Todo 项存储在本地文件中；
Todo 项索引逐一递增。

##第二阶段：支持多用户
用户登录。
todo login -u user
Password: 
Login success!
用户退出。
todo logout
Logout success!
要求：
只能看到当前用户的 Todo 列表；
同一个用户的 Todo 项索引逐一递增；
当前用户信息存储在配置文件中 ~/.todo-config。

##第三阶段：支持 Todo 列表导入和导出
Todo 列表导出。
todo export > todolist
Todo 列表导入。
todo import -f todolist
第四阶段：支持数据库持久化
在配置文件中，配置数据库连接信息。
初始化数据库。
todo init
要求：
没有数据库的情况下，使用本地文件；
在有数据库的情况下，使用数据库；
在本地文件已经存在的情况，将本地信息导入到数据库中。
以上我给出的是最基本的需求，你可以根据自己的实际编码情况，适当补充一些细节，比如，相应的错误提示。