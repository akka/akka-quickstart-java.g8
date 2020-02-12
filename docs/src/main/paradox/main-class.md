## The Main class
 
The `AkkaQuickstart` object in Hello World creates `ActorSystem` with a guardian. 
The guardian is the top level actor that bootstraps your application. The guardian
is typically defined with `Behaviors.setup` that contains the initial bootstrap.
 
@@snip [AkkaQuickstart.java]($g8src$/java/$package$/AkkaQuickstart.java)
 

