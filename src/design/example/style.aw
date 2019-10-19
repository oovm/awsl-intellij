// 首次载入时引入的代码
< script once>
let totalComponents = 0;

// 此处允许执行import操作，例如
// `import Example, { alertTotal } from './Example.svelte'`
export function alertTotal() {
    alert(totalComponents);
}

header.append_link()

</script>

<\script>
properties {
    src: String = 1;
}
reactive {
    document.title = title;
}

let src = 'tutorial/image.gif';
let name = 'Rick Astley';
</script>]

<script setup>
// 变量
const msg = 'Hello!'

// 函数
function log() {
  console.log(msg)
}
</script>

魔术指令


<template>
  <div
  on:click="log"
  @style="z-0"
  @style= {
  }
  >{{ msg }}


  </div>
</template>

<!-- {src} is short for src={src} -->
<img {src} alt="{name} dancing">



	p {
		/* 这只会影响此组件中的<p>标签 */
		color: burlywood;
	}
</style>
你可以选择使用 :global(...) 修饰符来添加全局样式。

< style global>
body {
    /* 这里样式全局应用于 <body>内都 */
    margin: 0;
}

div :global(strong) {
    /* 这里表示全局应用于被<div>包裹的<strong>标签 */
    color: goldenrod;
}
</style>



<script>
use widge.Widge;

import Widget from './Widget.svelte';
</script>

<div>
	<Widget/>
</div>


如果可以的话不要在 attribute 里写 `{ }`, 可读性太差了



<!-- 两者是等价的 -->
<button disabled={disabled}>...</button>
<button disabled>...</button>


<\tag>
此处为代码
</tag>


<style> 和 <script> 例外

<Widget ...things/>


<Widget ...$properties/>


<h1>Hello {name}!</h1>
<p>{a} + {b} = {a + b}.</p>


<!-- 这是一句注释！ -->
<h1>Hello world</h1>

以 svelte-ignore 开始的内容会被注释掉，直到位于注释闭合标签结束注释。

 一般来说，被注释的内容包含accessibility（a11y，一些对提高可访问性有帮助的信息）信息，所以请在有充足理由时才使用它。

<!-- svelte-ignore a11y-autofocus -->
<input bind:value={name} autofocus>



if answer === 42 {
    <p>what was the question?</p>
}

<p if="{answer === 42}">what was the question?</p>

let truth = answer === 42;

<p if=truth>what was the question?</p>


if (porridge.temperature > 100) {
	<p>too hot!</p>
}
ef (80 > porridge.temperature) {
    <p>too cold!</p>
}
else {
    <p>just right!</p>
}

<h1>Shopping list</h1>
<ul>
	{#each items as item}
		<li>{item.name} x {item.qty}</li>
	{/each}
</ul>


<\ul>
for item in items {
    <li>{item.name} x {item.qty}</li>
}
</ul>

{#await promise}
	<!-- promise 状态是“未决” -->
	<p>waiting for the promise to resolve...</p>
{:then value}
	<!-- promise 状态是 “完成” -->
	<p>The value is {value}</p>
{:catch error}
	<!-- promise 状态是“被拒绝” -->
	<p>Something went wrong: {error.message}</p>
{/await}


await promise {
    <p>waiting for the promise to resolve...</p>
}
ready value {

}
catch error {

}


<form on:submit|preventDefault={handleSubmit}>
	<!-- the `submit` event's default is prevented,
		 so the page won't reload -->
</form>

<form
    @preventDefault
    on-submit={handleSubmit}
    style="on"
    style={

    }
    style=[if a {"a"} else {""}]
>
	<!-- the `submit` event's default is prevented,
		 so the page won't reload -->
</form>



style 短指令

< div
    //? style accepts a list of style abbreviations
    //? see more: [tailwindcss](https://tailwindcss.com/)
    style = "flex w-48 relative"
    //?
    //? `style` can be repeated many times, and each style will accumulate
    style = {
        z_index: 0
    }
    //? You can also use a list to accumulate.
    //? which is especially suitable for dynamic changes.
    style = [theme]
    //? If you want to use css, this is not recommended
    //? `style-raw` setter will override all styles above
    style-raw = css"""
        padding: 1rem;
    """
    //?
    style:md = "bg-blue-500"
    style:lg = "bg-green-500"
/>

< style global>


</style>

style 断点

<div style="bg-green-500 md:bg-red-500 lg:bg-green-500">

</div>


<div
    style="bg-red-500"
    style:md="bg-blue-500"
    style:lg="bg-green-500"
>

</div>



