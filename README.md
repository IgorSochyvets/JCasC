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

Jenkins Deployment:
* without persistence:
```
export HELM_UPGRADE="helm upgrade -i jenkins-stg stable/jenkins --version 2.5.2 --set-string master.adminPassword=Password123$ --set persistence.enabled=false    -f ./jenkins-values.yml --debug --wait -n jenkins"

$HELM_UPGRADE

```

* with persistence:
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

Follow documentation: https://github.com/jenkinsci/configuration-as-code-plugin/tree/master/demos/kubernetes-secrets
1. Add ENV VAR `SECRETS`
2. Create Kubernetes secrets with all required values. 
```
edit jenkins-secrets.yaml
kubectl -f ./jenkins-secrets.yaml 
```
3. volumeMounts and volumes directives of Kubernetes manifest should have records for Kubernetes secrets mounts.
see `persistence:` section of `jenkins-values.yaml` file.
4. add JCasC configMap to `jenkins-values.yml` file
5. upgrade helm release:
```
$HELM_UPGRADE
```

#### Jobs 

