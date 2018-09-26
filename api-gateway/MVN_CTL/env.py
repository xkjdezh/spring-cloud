# -*- coding:UTF-8 -*-
#!/usr/bin/python
import paramiko
import os
import glob 
from util2 import Properties

dictProperties= Properties("../src/main/resources/application.properties")

env_dev="dev"
env_test="test"
env_prd="product"
value=env_test

def start_app():
   dictProperties.put("spring.profiles.active",value);
   print("设置执行环境为:" +value)
    
if __name__=='__main__':
   start_app()