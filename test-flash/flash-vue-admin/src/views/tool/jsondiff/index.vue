<template>
    <section>
        <div>
            <code-diff
                    :old-string="oldStr"
                    :new-string="newStr"
                    outputFormat="side-by-side"
                    :context="10"
            >
            </code-diff>
        </div>
    </section>
</template>
<script>
    import CodeDiff from "vue-code-diff";
    export default {
        name: "JSONCompare",
        components: { CodeDiff },
        data() {
            return {
                oldStr: "",
                newStr: ""
            };
        },
        mounted() {
            this.getgrouplist();
        },
        methods: {
            getgrouplist() {
                let oldJSON = {"measures":[{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.msg:AirlinesAbnormalTickets"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.etd:AirportDelayReason"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:CCChangeEventFLink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.data:DXYEpidemicStorage"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:DelayNeoFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:DetrUpdateFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:DipParserFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:EmdFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip:com.umetrip.data"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.datav.courier:courier"}]}
                let newJSON = {"measures":[{"metric":"coverage","value":"0.0","periods":[{"index":2,"value":"0.1"}],"component":"com.umetrip.msg:AirlinesAbnormalTickets"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.etd:AirportDelayReason"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:CCChangeEventFLink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.data:DXYEpidemicStorage"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:DelayNeoFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:DetrUpdateFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:DipParserFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip.flink:EmdFlink"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.umetrip:com.umetrip.data"},{"metric":"coverage","value":"0.0","periods":[{"index":1,"value":"0.0"}],"component":"com.datav.courier:courier"}]}
                this.oldStr = JSON.stringify(oldJSON, null, 4);
                this.newStr = JSON.stringify(newJSON, null, 4);
            },
        }
    };
</script>
<style scoped>
</style>
