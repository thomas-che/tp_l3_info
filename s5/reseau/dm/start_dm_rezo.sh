#! /bin/bash

tar xvfz ~/Téléchargements/labdm.tar.gz -C /tmp/
cp ~/Documents/dm_reseau/labdm/alice/root/senddns_com.py /tmp/labdm/alice/root/
cp ~/Documents/dm_reseau/labdm/boxa/root/proxydohtodns.py /tmp/labdm/boxa/root/
cp ~/Documents/dm_reseau/labdm/boxa/root/proxydohtodns.py /tmp/labdm/

cp ~/Documents/dm_reseau/labdm/boxa/root/proxy_pro.py /tmp/labdm/boxa/root/d_proxy_pro.py
cp ~/Documents/dm_reseau/labdm/boxa/root/proxy_pro.py /tmp/labdm/d_proxy_pro.py

cd /tmp/labdm/
lstart

code

