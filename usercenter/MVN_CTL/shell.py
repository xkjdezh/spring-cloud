# -*- coding:UTF-8 -*-
#!/usr/bin/python
import paramiko
import os
import glob 
from util2 import Properties
import env
from builtins import str
import difflib


dictProperties= Properties("../src/main/resources/application.properties")

#print(dictProperties.get("spring.application.name"))
#当前脚本路径
CUR_PATH = os.path.dirname(__file__)

#服务器ip
Host='www.nexus.com'
Port=22
#登录用户名
Username='root'
#登录密码
Password='BIchuang123456'
#登录服务器后执行的命令
Command = ['cd /data/prepare/sh; ./basic.sh']

#本地PC路径
WinPath = ""
#服务器上的路径
LinuxPrePath = '/data/prepare/apps2/pre/'
LinuxRunPath = '/data/prepare/apps2/run/'
LinuxPreRun='/data/prepare/apps2/libs/common'
ProjectName=""
JARName=""
LinuxJarFileFullName=""
## 级联创建的目录
Command1 = ['mkdir -p {"'+LinuxPrePath+'","'+LinuxRunPath+'","'+LinuxPreRun+'"}']

def ssh_exec_cmd(command):
    '''SSHA远程登录：Windows客户端连接Linux服务器，并输入指令'''

    #登录服务器
    ssh = paramiko.SSHClient()
    ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    ssh.connect(Host, Port, Username, Password)

    #执行命令
    for i in range(len(command)):
        
        send_str = command[i] 
        if(i !=len(command)):
            send_str = command[i] + '\n'
       
        stdin, stdout, stderr = ssh.exec_command(send_str)
        err = stderr.readlines()
        out = stdout.readlines()
        if (err):
            print ('error:')
            if(len(err)):
               for result in err:
                   print(result);
           
        else:
            if(len(out)):
               for result in out:
                   print(result);
           
    ssh.close()
   #执行完毕，终止连接
    
 

def ssh_linux_to_win(linuxpath, winpath):
    '''从Linux服务器下载文件到本地

    Args:
        linuxpath: 文件在服务器上的路径及名字
        winpath: 文件下载到本地的路径及名字

    '''

    client = paramiko.Transport((Host, Port))
    client.connect(username=Username, password=Password)
    sftp = paramiko.SFTPClient.from_transport(client)

    sftp.get(linuxpath, winpath)
    client.close()
    print ('DownLoad file finished!')

def ssh_win_to_linux(isnew,islibNew,iscommonNew):
    '''从windows向linux服务器上传文件

    Args:
        isnew: 是否需要上传新的jar包,大于0表示需要,否则表示不需要
        isLibNew: 是否需要上传第三方的jar包
        第三方通用jar包
    '''
    #print('上级目录winpath:'+ os.path.dirname(os.getcwd()) )
    proj=os.path.dirname(os.getcwd());
    workplace,ProjectName = os.path.split(proj)

    os.chdir( proj+"\\target") 
    app=["*.jar","*.war"]
    for a in app :
        f = glob.glob(a) 
        client = paramiko.Transport((Host, Port))
        client.connect(username=Username, password=Password)
        sftp = paramiko.SFTPClient.from_transport(client)
        for py in f: 
            if py.find("sources")== -1:
                    print(" 打印上传的文件 :"+py)
                    JARName=py
                   # print("mkdir -p {" +LinuxPrePath+ProjectName+","+LinuxRunPath+ProjectName+","+ LinuxRunPath+ProjectName+"/pid"+","+ LinuxRunPath+ProjectName+"/log""}")
                    Command2=["mkdir -p {" +LinuxPrePath+ProjectName+","+LinuxRunPath+ProjectName+","+ LinuxRunPath+ProjectName+"/pid"+","+ LinuxRunPath+ProjectName+"/log""}"]
                    LinuxJarFileFullName=LinuxPrePath+ProjectName+"/"+JARName
                    # 创建目录
                    ssh_exec_cmd(Command2)
                    if(int(isnew) >0) :
                        whichevn=dictProperties.get("spring.profiles.active")
                        print("environ:"+str(whichevn)+ " 正在上传的文件 :"+py+",到: " +(LinuxPrePath+ProjectName))
                        # 上传文件
                        sftp.put(py, LinuxJarFileFullName)
                        print(py+"已经上传到: " +(LinuxPrePath+ProjectName))
                    #修改设定的环境值
                    env.start_app()
                    Command6=["mkdir -p {" +LinuxRunPath+ProjectName+"/lib/,"+LinuxRunPath+ProjectName+"/bin/,"+LinuxRunPath+ProjectName+"/config/templates,"+LinuxRunPath+ProjectName+"/config/mapper/ext,"+LinuxPrePath+ProjectName+"/lib/,"+LinuxPrePath+ProjectName+"/config/mapper/ext,"+LinuxPrePath+ProjectName+"/config/templates}"]
                    ssh_exec_cmd(Command6)    
                    sftp_put_dir(proj+"/target/config" ,LinuxPrePath+ProjectName+"/config")  
                    print("更改配置文件: " +"cp -af " +LinuxPrePath+ProjectName+"/config/*  "+LinuxRunPath+ProjectName+"/config/")
                    Command7=["cp -af " +LinuxPrePath+ProjectName+"/config/*  "+LinuxRunPath+ProjectName+"/config/"]
                    ssh_exec_cmd(Command7)
                    if(int(islibNew) >0):
                         # lib 文件包
                        sftp_put_dir(proj+"\\target\\lib" ,LinuxPrePath+ProjectName+"/lib")  
                        print("cp -af " +LinuxPrePath+ProjectName+"/lib/*  "+LinuxRunPath+ProjectName+"/lib/")
                        Command8=["cp -af " +LinuxPrePath+ProjectName+"/lib/*  "+LinuxRunPath+ProjectName+"/lib/"]
                        ssh_exec_cmd(Command8)
                        
                    if(int(iscommonNew) >0):
                         # common lib 文件包
                        sftp_put_dir(proj+"\\target\\common" ,LinuxPreRun)  
                        print('uploda common libs to :' +LinuxPreRun)
                        
                    # 启动应用
                    start_app(LinuxJarFileFullName,LinuxRunPath+ProjectName,JARName)
                    
    print ('UpLoad file finished!')
    client.close()
    
def sftp_put_dir(local_dir, remote_dir):
        t = paramiko.Transport(sock=(Host, 22))
        t.connect(username=Username, password=Password)
        sftp = paramiko.SFTPClient.from_transport(t)

        # 去掉路径字符穿最后的字符'/'，如果有的话
        if remote_dir[-1] == '/':
            remote_dir = remote_dir[0:-1]

        # 获取本地指定目录及其子目录下的所有文件
        all_files = __get_all_files_in_local_dir(local_dir)
        
        # 依次put每一个文件
        for x in all_files:
            filename =x.split(local_dir)[-1].replace("\\","/")
            #print("index: " + x+",local_dir:" +local_dir)
            remote_filename = remote_dir +filename
            #print("X &&: " +str(x.split(local_dir)[-1]))
            #print (u'Put文件%s传输中...' % filename+",远程文件路径:" +remote_filename)
            sftp.put(x, remote_filename)
        print ('UpLoad config file finished!')   
        sftp.close()
        
# ------获取本地指定目录及其子目录下的所有文件------
def __get_all_files_in_local_dir(local_dir):
        # 保存所有文件的列表
        all_files = list()

        # 获取当前指定目录下的所有目录及文件，包含属性值
        files = os.listdir(local_dir)
        for x in files:
            # local_dir目录中每一个文件或目录的完整路径
            filename = os.path.join(local_dir, x)
            # 如果是目录，则递归处理该目录
            if os.path.isdir(filename):
                all_files.extend(__get_all_files_in_local_dir(filename))
            else:
                all_files.append(filename)
        return all_files     
           
def start_app(srcfulljarName,destfullProjName,jarName):
    whichevn=dictProperties.get("spring.profiles.active")
    query =Properties("../src/main/resources/application-"+whichevn+".properties")
    port=query.get("server.port")
    print("whichevn:" +whichevn+",port:" +port)
    #print("cp -r "+srcfulljarName+" " + destfullProjName)
    if(dictProperties.get("how.many.instences").strip() =="" or int(str(dictProperties.get("how.many.instences"))) == 1):
         ## 指定环境
         ssh_exec_cmd([ "cd /data/prepare/sh; ./cp.sh " +srcfulljarName+" " +destfullProjName,"cd /data/prepare/sh; ./start.sh " +" "+destfullProjName+" "+jarName+" " +whichevn+" "+str(int(port))]) 
         
    else:
                 ## 指定环境
        ssh_exec_cmd([ "cd /data/prepare/sh; ./cp.sh " +srcfulljarName+" " +destfullProjName,"cd /data/prepare/sh; ./start.sh " +" "+destfullProjName+" "+jarName+" " +whichevn]) 
       ## 指定环境指定端口
        ssh_exec_cmd([ "cd /data/prepare/sh; ./cp.sh " +srcfulljarName+" " +destfullProjName,"cd /data/prepare/sh; ./start.sh " +" "+destfullProjName+" "+jarName+" " +whichevn+" "+str(int(port)-10)])  
    
if __name__=='__main__':
   # print('Command1 :'+str(Command1))
    ssh_exec_cmd(Command1)
    ssh_win_to_linux(dictProperties.get("is.file.need",0),dictProperties.get("is.lib.need",0),dictProperties.get("is.commonlib.need",0))
    ssh_exec_cmd(Command)
    #ssh_exec_cmd()
    #ssh_linux_to_win(LinuxPath, WinPath)