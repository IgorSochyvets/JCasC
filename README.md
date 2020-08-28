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





#### Additional plugins Installation
* rewrite plugins on Jenkins start and erase plugins installed using UI

#### Configuring RBAC
* admin
* operator
* reader

#### Credentials

#### Jobs 

