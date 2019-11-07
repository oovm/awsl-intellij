
## Gilt Operation `※`

GILT 全称为 Globalization, Internationalization, Localization and translation)

表示全球化、国际化、本地化和翻译, 因为名称过长, 以下简称 **多语言算符(Gilt Operation)**.

```
// 
@@default_gilt(VomlBundle)
```

会寻找下上文中所有的 LanguageBundle

```aw
※LanguageBundle.message.path
※LanguageBundle.message.path(arg1, arg2)
```

完全形式为 VomlBundle.

fl!(loader, "hello-arg", name = format!("Bob {}", 23))

§.set_loader()


§message.hello

§message.hello()


i18n VomlBundle {
    
}

§VomlBundle.

$.set_default_resolver(VomlBundle::new())

⦂message.pointer

extends VomlBundle: GiltResolve {

}


VomlBundle.new_path(a)