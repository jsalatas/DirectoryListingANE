package gr.ictpro.jsalatas.ane.directorylisting
{
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.external.ExtensionContext;
	import flash.filesystem.File;
	
	public class DirectoryListing extends EventDispatcher
	{
		private var _ctx:ExtensionContext

		public function DirectoryListing(target:IEventDispatcher=null)
		{
			super(target);
			_ctx = ExtensionContext.createExtensionContext("gr.ictpro.jsalatas.ane.directorylisting", null);
		}
		
		public function dispose():void
		{
			_ctx.dispose();
		}
		
		public function isSupported():Boolean
		{
			return _ctx.call("isSupported");
		}
		
		public function getDirectoryListing(path:String):Array
		{
			//return super.getDirectoryListing();
			var o:Object = _ctx.call("getDirectoryListing", path);
			var fileArray:Vector.<String> = o!=null?Vector.<String>(o):new Vector.<String>();
			var files:Array = new Array();
			for each(var fString:String in fileArray) {
				files.push(new File(path+"/"+fString));
			}
			
			return files;
		}
		
	}
}