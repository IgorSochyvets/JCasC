# JCasC
Jenkins LTS Configuration as Code

#### Jenkins installation
* https://hub.helm.sh/charts/stable/jenkins
* helm install stable/jenkins --version 2.5.2

```
k create ns jenkins
k apply -f pv_jenkins.yaml -n jenkins
```

TMP command  (no persistece / later add     --set-string persistence.size=8Gi \ )
```
helm upgrade -i jenkins-stg \
  stable/jenkins \
  --version 2.5.2 \
  --set-string master.adminPassword=Password123$ \
  --set persistence.enabled=false  \
  -f ./jenkins-values.yml \
  --debug \
  --wait  \   
  -n jenkins
```

```
helm upgrade --install jenkins \
    --namespace=jenkins \
    --version v1.9.4 \
    --set master.ingress.enabled=true \
    --set-string master.ingress.hostName=$site_name \
    --set-string master.ingress.annotations."kubernetes\.io/tls-acme"=true \
    --set-string master.ingress.annotations."kubernetes\.io/ssl-redirect"=true \
    --set-string master.ingress.annotations."kubernetes\.io/ingress\.class"=nginx \
    --set-string master.ingress.tls[0].hosts[0]=$site_name \
    --set-string master.ingress.tls[0].secretName=acme-jenkins-tls \
    --set-string persistence.size=8Gi \
    stable/jenkins
```




#### Additional plugins Installation
* rewrite plugins on Jenkins start and erase plugins installed using UI

#### Configuring RBAC
* admin
* operator
* reader

#### Credentials

#### Jobs 

