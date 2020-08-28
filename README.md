# JCasC
Jenkins LTS Configuration as Code

#### Jenkins installation
* https://hub.helm.sh/charts/stable/jenkins
* helm install stable/jenkins --version 2.5.2

```
k create ns jenkins
k apply -f pv_jenkins.yaml -n jenkins
helm repo add stable https://kubernetes-charts.storage.googleapis.com/ 
```

Jenkins Deploymant:

```
helm upgrade -i jenkins-stg \
  stable/jenkins \
  --version 2.5.2 \
  --set-string master.adminPassword=Password123$ \
  --set persistence.enabled=true  \
  --set-string persistence.size=8Gi \
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
see `jenkins-values.yml` file, section JCasC

#### Jobs 

