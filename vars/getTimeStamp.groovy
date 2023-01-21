def String call() {
   Date date = new Date()
   return date.format('yyyyMMddHHmmss',TimeZone.getTimeZone('EST')) as String
}
return this
