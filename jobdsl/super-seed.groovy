job('super-seed') {
  scm {
    git {
      remote {
        url ('git@github.com:IgorSochyvets/JCasC.git')
      }
    }
  }
  steps {
    dsl {
      external('jobdsl/**/*.groovy')
      removeAction('DELETE')
    }
  }
}

