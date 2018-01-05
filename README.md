# FolderCleaner

使用 Launch4j，并与 Gradle Kotlin DSL 相互配合，实现自动化生成 `exe` 可执行文件。

```
D:\Download\1234>dir
2018/01/05  11:26    <DIR>          .
2018/01/05  11:26    <DIR>          ..
2018/01/05  11:23             5,469 abc (1).diff
2018/01/05  11:23             5,469 abc (2).diff
2018/01/05  11:23             5,469 abc (3).diff
2018/01/05  11:23             5,469 abc (4).diff
2018/01/05  11:23             5,469 abc.diff
2018/01/05  11:13         1,007,612 FolderCleaner.exe
2018/01/05  11:23                 0 新建文本文档 (1).txt
2018/01/05  11:23                 0 新建文本文档 (2).txt
2018/01/05  11:23                 0 新建文本文档 (3).txt
2018/01/05  11:23                 0 新建文本文档.txt

D:\Download\1234>FolderCleaner.exe
.\abc (3).diff
.\abc (2).diff
.\abc (1).diff
.\abc.diff
.\新建文本文档 (2).txt
.\新建文本文档 (1).txt
.\新建文本文档.txt
是否要删除以上文件（y or n）：y
已删除：.\abc (3).diff
已删除：.\abc (2).diff
已删除：.\abc (1).diff
已删除：.\abc.diff
已删除：.\新建文本文档 (2).txt
已删除：.\新建文本文档 (1).txt
已删除：.\新建文本文档.txt
已完成!

D:\Download\1234>dir
2018/01/05  11:28    <DIR>          .
2018/01/05  11:28    <DIR>          ..
2018/01/05  11:23             5,469 abc (4).diff
2018/01/05  11:13         1,007,612 FolderCleaner.exe
2018/01/05  11:23                 0 新建文本文档 (3).txt
```
